package com.caakdogan.snake;

/**
 * Created by Arif-Admin on 03.03.2017.
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;


public class Snake implements KeyReceiver,GameElement{
    private ArrayList<Point> body;
    private Color col;
    private Color defaultColor;
    private HashMap<Point, GameElement> map;
    private int xMovement;
    private int yMovement;
    private boolean growSnake;
    private boolean resetColor;
    private int score;
    private GamePanel gamePanel;

    public static final int LEFT = 1;
    public static final int UP = 2;
    public static final int RIGHT = 3;
    public static final int DOWN = 4;

    public Snake(Point p, int dir, Color col, HashMap<Point, GameElement> map, GamePanel gamePanel)
    {
        this.col = col;
        this.defaultColor = col;
        this.map = map;
        this.gamePanel = gamePanel;
        this.score = 0;
        body = new ArrayList<Point>();

        this.newSegment(p);
        this.growSnake = false;
        resetColor = false;
        this.xMovement = 0;
        this.yMovement = 0;
        this.changeDirection(dir);
        this.newSegment(new Point(this.body.get(0).x - xMovement, this.body.get(0).y - yMovement ));

    }



    public void moveSnake()
    {
        if (resetColor)
        {
            this.col = this.defaultColor;
            this.resetColor = false;
        }
        Point tempPoint = new Point(
                body.get(0).x + this.xMovement,
                body.get(0).y + this.yMovement
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
    }

    private void detectCollision(Point tempPoint) {
        if (this.map.containsKey(tempPoint))
        {
            System.out.println("COLLISION DETECTED");
            if (this.map.get(tempPoint) instanceof Fruit)
            {
                this.gamePanel.removeFruit(tempPoint);
                this.setGrowth(true);
                this.score++;
            }
            else if (this.map.get(tempPoint) instanceof Snake || this.map.get(tempPoint) instanceof SnakeObstacle )
            {
                this.gamePanel.stopGame(this.score);
            }

            this.col = new Color(25, 192, 229);
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
    public void changeDirection(int direction)
    {
        switch (direction)
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
        body.add(p);
        this.map.put(p, this);

    }

    public void newSegment(Point p, int index)
    {
        body.add(index, p);
        this.map.put(p, this);
    }


    public void removeSegment(int index)
    {
        this.map.remove(this.body.get(index));
        this.body.remove(index);
    }


    public void setGrowth(boolean b)
    {
        this.growSnake = b;
    }


    public void draw(Graphics g)
    {
        g.setColor(this.col);
        for (Point p : body)
        {
            g.fillRect(p.x, p.y, SnakeConfig.GRID_SIZE, SnakeConfig.GRID_SIZE);
        }
    }

    @Override
    public void reactToKey(KeyEvent e) {
        System.out.println("Snake received Key: " + e.getKeyCode());
        switch(e.getKeyCode())
        {
            case 37: this.changeDirection(Snake.LEFT);
                break;
            case 38: this.changeDirection(Snake.UP);
                break;
            case 39: this.changeDirection(Snake.RIGHT);
                break;
            case 40: this.changeDirection(Snake.DOWN);
                break;
            case 83: this.setGrowth(true);
                break;
            case 88: System.out.println("BREAK");
                break;
            // case 80: game.clear();
            //break;
        }
    }
}
