package com.caakdogan.snake;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.Point;
import java.util.Timer;

class GamePanel extends JPanel {
    ArrayList<Snake> players;
    ArrayList<Fruit> fruits;
    ArrayList<SnakeObstacle> obstacles;

    HashMap<Point, GameElement> map;

    private Timer timer;
    private TimedDraw drawTask; // to GamePanel
    private TimedMove moveTask; // to GamePanel

    private SnakeFrame game;


    public GamePanel(int numberOfPlayers, SnakeFrame game)
    {
        this.game = game;
        System.out.println("Starting a " + numberOfPlayers + " Player Game");
        this.initialize();
    }

    public void initialize()
    {
        this.players = new ArrayList<Snake>();
        this.fruits = new ArrayList<Fruit>();
        this.obstacles = new ArrayList<SnakeObstacle>();
        this.map = new HashMap<Point, GameElement>();
        this.timer = new Timer();
        Snake player1 = new Snake(new Point(SnakeConfig.GRID_SIZE* 2, SnakeConfig.GRID_SIZE * 2), Snake.RIGHT, Color.BLUE, this.map, this );
        this.players.add(player1);
        this.game.skl.clearReceivers();
        this.game.skl.addReceiver(player1);

        this.createPerimeter();
        this.newFruit();
        this.drawTask = new TimedDraw(this);
        this.moveTask = new TimedMove(players);
        //timer.schedule( drawTask, 1000, 20);
        timer.scheduleAtFixedRate( moveTask, 1000, 120);
        timer.scheduleAtFixedRate( drawTask, 1000, 20);
    }




    public void stopGame(int score)
    {
        this.drawTask.switchTaskOff();
        this.timer.cancel();
        System.out.println("Game Stopped");
        this.game.stopGame(score);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the Snakes
        for (Snake s : this.players)
        {
           s.draw(g);
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

    public void createPerimeter()
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


    public void newFruit()
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
