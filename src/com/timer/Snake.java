package com.timer;

/**
 * Created by Arif-Admin on 03.03.2017.
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class Snake {
    private ArrayList<SnakeSegment> body;
    private Color col;
    private Color defaultColor;
    private GameField map;
    private int xMovement;
    private int yMovement;
    private boolean growSnake;
    private boolean resetColor;

    public static final int LEFT = 1;
    public static final int UP = 2;
    public static final int RIGHT = 3;
    public static final int DOWN = 4;

    public Snake(Point p, int dir, Color col, GameField map)
    {
        this.col = col;
        this.defaultColor = col;
        this.map = map;
        body = new ArrayList<SnakeSegment>();

        this.newSegment(p);
        this.growSnake = false;
        resetColor = false;
        this.xMovement = 0;
        this.yMovement = 0;
        this.changeDirection(dir);
        this.newSegment(new Point(this.body.get(0).p.x - xMovement, this.body.get(0).p.y - yMovement ));

    }



    public void moveSnake()
    {

        if (resetColor)
        {
            this.col = this.defaultColor;
            this.resetColor = false;
        }

        Point tempPoint = new Point(
                body.get(0).p.x + this.xMovement,
                body.get(0).p.y + this.yMovement
        );
        this.detectCollision(tempPoint);



        this.newSegment(tempPoint, 0);


        if (!growSnake)
        {
            this.removeSegment(body.size()-1);
        }
        else {
            this.growSnake = false;
        }


        //body.get(0).p.x += xMovement;
        //body.get(0).p.y += yMovement;
        //System.out.println("Snake X: " + body.get(0).p.x);
    }

    private void detectCollision(Point tempPoint) {
        if (this.map.locationHasContent(tempPoint))
        {
            System.out.println("COLLISION DETECTED");
            if (this.map.checkLocation(tempPoint) instanceof Fruit)
            {
                this.map.removeFruit(tempPoint);
                this.setGrowth(true);
            }
            else if (this.map.checkLocation(tempPoint) instanceof SnakeSegment )
            {
                System.out.println(" ITS MY TAIL");
            }

            this.col = Color.RED;
            this.resetColor = true;
        }
    }

    /*
    Changes the direction if the Snake like this:
    1 : Left
    2 : Up
    3 : Right
    4 : Down
    @Param direction a value between 1 and 4;
     */
    public void changeDirection(int dir)
    {
        switch (dir)
        {
            case LEFT:
            {
                this.xMovement = 0 - SnakeConfig.GRID_SIZE;
                this.yMovement = 0;
            }
            break;
            case UP:
            {
                this.xMovement = 0;
                this.yMovement = 0 - SnakeConfig.GRID_SIZE;
            }
            break;
            case RIGHT:
            {
                this.xMovement = SnakeConfig.GRID_SIZE;
                this.yMovement = 0;
            }
            break;
            case DOWN:
            {
                this.xMovement = 0;
                this.yMovement = SnakeConfig.GRID_SIZE;
            }
            break;
        }
       // System.out.println("DIR: " + dir + " | " + "x-dir: " + xMovement + " | y-dir: " + yMovement);
    }

    public void newSegment(Point p)
    {

        SnakeSegment tempSegment = new SnakeSegment(p, SnakeConfig.GRID_SIZE);
        body.add(tempSegment);
        this.map.addValue(p, tempSegment);

    }

    public void newSegment(Point p, int index)
    {
        SnakeSegment tempSegment = new SnakeSegment(p, SnakeConfig.GRID_SIZE);
        body.add(index, tempSegment);
        this.map.addValue(tempSegment.p, tempSegment);
    }

    public void newLastSegment()
    {
        SnakeSegment tempSegment = new SnakeSegment(body.get(body.size()-1).p, SnakeConfig.GRID_SIZE);
        body.add(tempSegment);
        this.map.addValue(tempSegment.p, tempSegment);
    }

    public void removeSegment(int index)
    {
        this.map.removeValue(this.body.get(index).p);
        this.body.remove(index);
    }

    public Point getSegment(int index)
    {
        return body.get(index).p;
    }

    public int getNumberOfSegments()
    {
        return this.body.size();
    }

    public void setGrowth(boolean b)
    {
        this.growSnake = b;
    }

    public Color getColor()
    {
        return this.col;
    }

}
