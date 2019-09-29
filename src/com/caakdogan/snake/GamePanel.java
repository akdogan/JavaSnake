package com.caakdogan.snake;

import com.caakdogan.shared.GameElement;
import com.caakdogan.shared.GridPoint;
import com.caakdogan.shared.SnakeConfig;
import com.caakdogan.shared.SnakeObstacle;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;

/**
 * Created by Arif Akdogan on 03.03.2017.
 * Extended JPanel that's responsible for drawing and managing all Elements during the actual Game
 */
class GamePanel extends JPanel {
    private ArrayList<Snake> players;
    private ArrayList<Fruit> fruits;
    private ArrayList<SnakeObstacle> obstacles;

    HashMap<GridPoint, GameElement> map;

    private Timer timer;
    private TimedDraw drawTask; // to GamePanel
    private TimedMove moveTask; // to GamePanel

    public SnakeFrame game;


    public GamePanel(int numberOfPlayers, int speed, SnakeFrame game, Color p1, Color p2, String mapName)
    {
        this.game = game;
        //System.out.println("Starting a " + numberOfPlayers + " Player Game");
        this.initialize(numberOfPlayers, speed, p1, p2, mapName);
        this.game.setSize(SnakeConfig.WINDOW_WIDTH, SnakeConfig.WINDOW_HEIGHT + ( numberOfPlayers * SnakeConfig.MENU_BLOCK_HEIGHT));
    }

    // TODO: initialize() probably not necessary, can go into constructor
    private void initialize(int numberOfPlayers, int speed, Color p1, Color p2, String mapName)
    {
        this.players = new ArrayList<>();
        this.fruits = new ArrayList<>();
        this.obstacles = new ArrayList<>();
        this.map = new HashMap<>();
        this.timer = new Timer();

        this.game.skl.clearReceivers();
        GridPoint p = new GridPoint(10, 10);
        // Add first Snake
        this.players.add(new Snake(
                new GridPoint(
                        SnakeConfig.FIELD_WIDTH - 3,
                        SnakeConfig.FIELD_HEIGHT - 3),
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
                    new GridPoint(2, 2),
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

        LevelGenerator levGen = new LevelGenerator(map);
        this.obstacles = levGen.generateLevel(mapName);

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
        //System.out.println("Game Stopped");
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

        int y = SnakeConfig.CANVAS_HEIGHT ;
        int x = 5;

        for (Snake s : this.players)
        {
           s.draw(g);
           y += SnakeConfig.MENU_BLOCK_HEIGHT - 5;
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

    private void newFruit()
    {
        fruits.add(new Fruit(this.map));
    }

    public void removeFruit(GridPoint removePoint)
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
