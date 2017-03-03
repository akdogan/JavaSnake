package com.timer;

/**
 * Created by Arif-Admin on 03.03.2017.
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class Snake{
    private ArrayList<SnakeSegment> body;
    private Color col;
    int xMovement;
    int yMovement;

    static final int LENGTH = 10;
    // Hardcoded hack
    static final int MOVE = 10;

    public Snake(Point p, int dir, Color col)
    {
        this.col = col;
        body = new ArrayList<SnakeSegment>();
        this.newSegment(p);
        this.xMovement = 0;
        this.yMovement = 0;
        this.changeDirection(dir);

    }

    public void moveSnake()
    {
        /*
        Point temp = new Point(body.get(0).p.x + MOVE, body.get(0).p.y);
        body.add(0, new SnakeSegment(temp, LENGTH));
        body.remove(body.size()-1);
        */
        body.get(0).p.x += xMovement;
        body.get(0).p.y += yMovement;
        System.out.println("Snake X: " + body.get(0).p.x);
    }

    /*
    Changes the direction if the Snake like this:
    1 : Left
    2 : Up
    3: Right
    4: Down
    @Param direction a value between 1 and 4;
     */
    public void changeDirection(int dir)
    {
        switch (dir)
        {
            case 1:
            {
                this.xMovement = 0 - MOVE;
                this.yMovement = 0;
            }
            break;
            case 2:
            {
                this.xMovement = 0;
                this.yMovement = 0 - MOVE;
            }
            break;
            case 3:
            {
                this.xMovement = MOVE;
                this.yMovement = 0;
            }
            break;
            case 4:
            {
                this.xMovement = 0;
                this.yMovement = MOVE;
            }
            break;
        }
        System.out.println("DIR: " + dir + " | " + "x-dir: " + xMovement + " | y-dir: " + yMovement);
    }

    public void newSegment(Point p)
    {
        body.add(new SnakeSegment(p, LENGTH));
    }

    public void newSegment()
    {
        body.add(new SnakeSegment(body.get(body.size()-1).p, LENGTH));
    }

    public Point getSegment(int index)
    {
        return body.get(index).p;
    }

    public Color getColor()
    {
        return this.col;
    }

}
