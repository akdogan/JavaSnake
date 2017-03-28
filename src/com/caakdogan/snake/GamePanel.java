package com.caakdogan.snake;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.Point;
import java.util.Timer;

/**
 * Created by Arif Akdogan on 03.03.2017.
 * Extended JPanel that's responsible for drawing and managing all Elements during the actual Game
 */
class GamePanel extends JPanel {
    private ArrayList<Snake> players;
    private ArrayList<Fruit> fruits;
    private ArrayList<SnakeObstacle> obstacles;

    HashMap<Point, GameElement> map;

    private Timer timer;
    private TimedDraw drawTask; // to GamePanel
    private TimedMove moveTask; // to GamePanel

    public SnakeFrame game;


    public GamePanel(int numberOfPlayers, int speed, SnakeFrame game, Color p1, Color p2)
    {
        this.game = game;
        System.out.println("Starting a " + numberOfPlayers + " Player Game");
        this.initialize(numberOfPlayers, speed, p1, p2);
        this.game.setSize(SnakeConfig.WINDOW_WIDTH, SnakeConfig.WINDOW_HEIGHT + ( numberOfPlayers * SnakeConfig.HUD_HEIGHT_PER_LABEL));
    }

    // TODO: initialize() probably not necessary, can go into constructor
    private void initialize(int numberOfPlayers, int speed, Color p1, Color p2)
    {
        this.players = new ArrayList<>();
        this.fruits = new ArrayList<>();
        this.obstacles = new ArrayList<>();
        this.map = new HashMap<>();
        this.timer = new Timer();

        this.game.skl.clearReceivers();

        // Add first Snake
        this.players.add(new Snake(
                new Point(
                        SnakeConfig.FIELD_WIDTH - SnakeConfig.GRID_SIZE * 3,
                        SnakeConfig.FIELD_HEIGHT - SnakeConfig.GRID_SIZE * 3),
                Snake.LEFT,
                SnakeConfig.PLAYER_1_DEFAULT_LEFT,
                SnakeConfig.PLAYER_1_DEFAULT_UP,
                SnakeConfig.PLAYER_1_DEFAULT_RIGHT,
                SnakeConfig.PLAYER_1_DEFAULT_DOWN,
                p1,
                "Player 1",
                this
        ));

        // Add second Snake
        if (numberOfPlayers > 1)
        {
            this.players.add(new Snake(
                    new Point(
                            SnakeConfig.GRID_SIZE * 2,
                            SnakeConfig.GRID_SIZE * 2),
                    Snake.RIGHT,
                    SnakeConfig.PLAYER_2_DEFAULT_LEFT,
                    SnakeConfig.PLAYER_2_DEFAULT_UP,
                    SnakeConfig.PLAYER_2_DEFAULT_RIGHT,
                    SnakeConfig.PLAYER_2_DEFAULT_DOWN,
                    p2,
                    "Player 2",
                    this
            ));
        }

        this.createPerimeter();
        this.newFruit();
        this.drawTask = new TimedDraw(this);
        this.moveTask = new TimedMove(players);
        timer.scheduleAtFixedRate( moveTask, 1000, speed);
        timer.scheduleAtFixedRate( drawTask, 1000, 20);
    }


    public void stopGame()
    {
        this.drawTask.switchTaskOff();
        this.timer.cancel();
        System.out.println("Game Stopped");
        ArrayList<String> scores = new ArrayList<>();
        for (int i = 0; i < players.size(); i++)
        {
            String str = players.get(i).name + ": " + players.get(i).score + " Points";
            scores.add(str);
        }
        this.game.stopGame(scores);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.setFont(SnakeConfig.HUD_FONT);

        int y = SnakeConfig.FIELD_HEIGHT ;
        int x = 5;

        for (Snake s : this.players)
        {
           s.draw(g);
           y += SnakeConfig.HUD_HEIGHT_PER_LABEL - 5;
           g.drawString(s.name + " score: " + s.score, x, y);
        }
        // Draw the Fruits
        for (Fruit f : this.fruits)
        {
           f.draw(g);
        }
        // Draw the obstacles
        for (SnakeObstacle o : this.obstacles )
        {
            o.draw(g);
        }
    }

    private void createPerimeter()
    {
        // create top row
        for (int i = 0; i < SnakeConfig.FIELD_WIDTH; i += SnakeConfig.GRID_SIZE)
        {
            Point tempPoint = new Point(i, 0);
            this.obstacles.add(new SnakeObstacle(this.map, tempPoint));
        }
        // create left side
        for ( int i = SnakeConfig.GRID_SIZE; i < SnakeConfig.FIELD_HEIGHT; i += SnakeConfig.GRID_SIZE)
        {
            Point tempPoint = new Point(0, i);
            this.obstacles.add(new SnakeObstacle(this.map, tempPoint));
        }
        for ( int i = SnakeConfig.GRID_SIZE; i < SnakeConfig.FIELD_HEIGHT; i += SnakeConfig.GRID_SIZE)
        {
            Point tempPoint = new Point(SnakeConfig.FIELD_WIDTH - SnakeConfig.GRID_SIZE, i);
            this.obstacles.add(new SnakeObstacle(this.map, tempPoint));
        }
        for ( int i = SnakeConfig.GRID_SIZE; i < SnakeConfig.FIELD_WIDTH - SnakeConfig.GRID_SIZE; i += SnakeConfig.GRID_SIZE)
        {
            Point tempPoint = new Point(i, SnakeConfig.FIELD_HEIGHT - SnakeConfig.GRID_SIZE);
            this.obstacles.add(new SnakeObstacle(this.map, tempPoint));
        }
    }


    private void newFruit()
    {
        fruits.add(new Fruit(this.map));
    }

    public void removeFruit(Point removePoint)
    {
        for (int i = 0; i < fruits.size(); i++)
        {
            if (fruits.get(i).p.equals(removePoint))
            {
                this.fruits.remove(i);
                newFruit();
            }
        }
    }


}
