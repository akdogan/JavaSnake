package com.caakdogan.snake;

import javax.swing.*;
import java.util.Timer;
import java.awt.*;
import java.util.*;


/**
 * Created by Arif-Admin on 03.03.2017.
 */
public class GameField {

    HashMap<Point, GameElement> map;
    ArrayList<Fruit> fruits;
    ArrayList<SnakeObstacle> obstacles;
    ArrayList<Snake> players;
    private Timer Timer;
    private JFrame f;
    private TimedDraw drawTask;
    private TimedMove moveTask;
    private DrawPanel canvas;
    private DrawMenu gameover;
    private SnakeKeyListener skl;

    public GameField()
    {
        this.map = new HashMap<Point, GameElement>();
        this.fruits = new ArrayList<Fruit>();
        this.obstacles = new ArrayList<SnakeObstacle>();
        this.canvas = new DrawPanel(players, fruits, obstacles);
        this.f = new JFrame();
        this.Timer = new java.util.Timer();
        this.initialize();

    }

    public void createPerimeter()
    {
        // create top row
        for (int i = 0; i < SnakeConfig.FIELD_WIDTH; i += SnakeConfig.GRID_SIZE)
        {
            Point tempPoint = new Point(i, 0);
            this.obstacles.add(new SnakeObstacle(this, tempPoint));
        }

        // create left side
        for ( int i = SnakeConfig.GRID_SIZE; i < SnakeConfig.FIELD_HEIGHT; i += SnakeConfig.GRID_SIZE)
        {
            Point tempPoint = new Point(0, i);
            this.obstacles.add(new SnakeObstacle(this, tempPoint));
        }

        for ( int i = SnakeConfig.GRID_SIZE; i < SnakeConfig.FIELD_HEIGHT; i += SnakeConfig.GRID_SIZE)
        {
            Point tempPoint = new Point(SnakeConfig.FIELD_WIDTH - SnakeConfig.GRID_SIZE, i);
            this.obstacles.add(new SnakeObstacle(this, tempPoint));
        }

        for ( int i = SnakeConfig.GRID_SIZE; i < SnakeConfig.FIELD_WIDTH - SnakeConfig.GRID_SIZE; i += SnakeConfig.GRID_SIZE)
        {
            Point tempPoint = new Point(i, SnakeConfig.FIELD_HEIGHT - SnakeConfig.GRID_SIZE);
            this.obstacles.add(new SnakeObstacle(this, tempPoint));
        }
    }

    public void initialize()
    {
        this.players = new ArrayList<Snake>();
        players.add(new Snake(new Point(SnakeConfig.GRID_SIZE*3, SnakeConfig.GRID_SIZE*3), 3, Color.BLUE, this));

        this.canvas = new DrawPanel(players, fruits, obstacles);
        this.f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.f.setSize( SnakeConfig.WINDOW_WIDTH, SnakeConfig.WINDOW_HEIGHT );
        this.f.add(canvas);
        //System.out.println("height:" + canvas.getSize().height);
        this.f.setVisible( true );
        this.skl = new SnakeKeyListener(players.get(0), this);
        this.f.addKeyListener(skl);
        System.out.println("f Components:" + this.f.getRootPane().getComponentCount());
        this.createPerimeter();
        this.newFruit();
        this.drawTask = new TimedDraw(canvas, f);
        this.moveTask = new TimedMove(players);
        //timer.schedule( drawTask, 1000, 20);
        Timer.scheduleAtFixedRate( moveTask, 1000, 120);
        Timer.scheduleAtFixedRate(drawTask, 1000, 20);
    }

    public void clear()
    {
        this.map = new HashMap<Point, GameElement>();
        this.fruits = new ArrayList<Fruit>();
        this.Timer = new java.util.Timer();
        this.f.remove(gameover);
        if (this.f.getKeyListeners() != null)
        {
            this.f.removeKeyListener(skl);
        }
        this.initialize();

    }


    public void stopGame(int score)
    {
        this.drawTask.switchTaskOff();
        this.Timer.cancel();
        this.gameover = new DrawMenu(score);
        System.out.println(f.getComponent(0));
        f.remove(this.canvas);
        f.add(this.gameover);
        f.setVisible( true );
        f.repaint();
    }


    public boolean locationHasContent(Point p)
    {
        return map.containsKey(p);
    }

    public GameElement checkLocation(Point p)
    {
        return map.get(p);
    }

    public void addValue(Point p, GameElement element)
    {
        map.put(p, element);
    }

    public void removeValue(Point p)
    {
        this.map.remove(p);
    }

    public void newFruit()
    {
        fruits.add(new Fruit(this));
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