package com.timer;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;


/**
 * Created by Arif-Admin on 03.03.2017.
 */
public class GameField {

    HashMap<Point, GameElement> map;
    ArrayList<Fruit> fruits;

    public GameField()
    {
        map = new HashMap<Point, GameElement>();
        fruits = new ArrayList<Fruit>();
        newFruit();
        Snake player1 = new Snake(new Point(100, 100), 3, Color.BLUE, this);
        //Snake player2 = new Snake(10, 10, 50, Color.ORANGE);
        ArrayList<Snake> players = new ArrayList<Snake>();
        players.add(player1);

        DrawPanel canvas = new DrawPanel(players, fruits);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setSize( SnakeConfig.WINDOW_WIDTH, SnakeConfig.WINDOW_HEIGHT );
        f.add(canvas);
        f.setVisible( true );
        SnakeKeyListener sKL = new SnakeKeyListener(players.get(0));
        f.addKeyListener(sKL);

        java.util.Timer timer = new java.util.Timer();
        timer.schedule( new TimedDraw(canvas, f), 1000, 20);
        timer.schedule( new TimedMove(players), 1000, 120);
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