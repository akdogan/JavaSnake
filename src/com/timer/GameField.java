package com.timer;

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
    private Timer timer;
    private JFrame f;
    private TimedDraw drawTask;
    private TimedMove moveTask;
    private DrawPanel canvas;

    public GameField()
    {
        map = new HashMap<Point, GameElement>();
        fruits = new ArrayList<Fruit>();
        newFruit();
        Snake player1 = new Snake(new Point(100, 100), 3, Color.BLUE, this);
        //Snake player2 = new Snake(10, 10, 50, Color.ORANGE);
        ArrayList<Snake> players = new ArrayList<Snake>();
        players.add(player1);

        this.canvas = new DrawPanel(players, fruits);


        f = new JFrame();
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setSize( SnakeConfig.WINDOW_WIDTH, SnakeConfig.WINDOW_HEIGHT );
        f.add(canvas);
        f.setVisible( true );
        SnakeKeyListener sKL = new SnakeKeyListener(players.get(0));
        f.addKeyListener(sKL);

        this.timer = new java.util.Timer();

        this.drawTask = new TimedDraw(canvas, f);
        this.moveTask = new TimedMove(players);
        //timer.schedule( drawTask, 1000, 20);
        timer.scheduleAtFixedRate( moveTask, 1000, 120);
        timer.scheduleAtFixedRate(drawTask, 1000, 120);
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

    public void stopGame(int score)
    {

        //System.out.println(this.drawTask.scheduledExecutionTime());
        this.drawTask.switchTaskOff();
        this.timer.cancel();
        DrawMenu gameover = new DrawMenu(score);
        System.out.println(f.getComponent(0));
        f.remove(canvas);

        f.add(gameover);
        f.setVisible( true );
        f.repaint();
        //Timer menuTimer = new Timer();
        //menuTimer.schedule(new TimedDraw(gameover, f), 1000, 20);

    }


}