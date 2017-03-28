package com.caakdogan.snake;

/**
 * Created by Arif-Admin on 03.03.2017.
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Snake implements KeyReceiver,GameElement{
    private ArrayList<Point> body;
    private Color col;
    private Color defaultColor;
    private int currentDirection;
    private int xMovement;
    private int yMovement;
    private boolean growSnake;
    private boolean resetColor;
    public int score;
    private GamePanel gamePanel;

    public String name;

    public final int leftKey;
    public final int upKey;
    public final int rightKey;
    public final int downKey;

    public static final int LEFT = 1;
    public static final int UP = 2;
    public static final int RIGHT = 3;
    public static final int DOWN = 4;

    public Snake(
            Point p,
            int dir,
            int leftKey,
            int upKey,
            int rightKey,
            int downKey,
            Color col,
            String name,
            GamePanel gamePanel)
    {
        this.col = col;
        this.defaultColor = col;
        this.name = name;
        this.gamePanel = gamePanel;
        this.score = 0;
        body = new ArrayList<>();

        this.leftKey = leftKey;
        this.upKey = upKey;
        this.rightKey = rightKey;
        this.downKey = downKey;

        this.newSegment(p);
        this.growSnake = false;
        resetColor = false;
        this.xMovement = 0;
        this.yMovement = 0;
        this.changeDirection(dir);

        this.gamePanel.game.skl.addReceiver(this);
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
        if (this.gamePanel.map.containsKey(tempPoint))
        {
            System.out.println("COLLISION DETECTED");
            if (this.gamePanel.map.get(tempPoint) instanceof Fruit)
            {
                this.gamePanel.removeFruit(tempPoint);
                this.setGrowth(true);
                this.score++;
            }
            else if (this.gamePanel.map.get(tempPoint) instanceof Snake || this.gamePanel.map.get(tempPoint) instanceof SnakeObstacle )
            {
                this.gamePanel.stopGame();
            }

            this.col = new Color(25, 192, 229);
            this.resetColor = true;
        }
    }

    /**
    * Changes the direction of the snake
    * @Param direction a value between 1 and 4 of LEFT, UP, RIGHT, DOWN
    */
    public void changeDirection(int direction)
    {
        if ( direction != this.getOppositeDirection(this.currentDirection))
        {
            switch (direction) {
                case LEFT: {
                    this.xMovement = 0 - SnakeConfig.GRID_SIZE;
                    this.yMovement = 0;
                }
                break;
                case UP: {
                    this.xMovement = 0;
                    this.yMovement = 0 - SnakeConfig.GRID_SIZE;
                }
                break;
                case RIGHT: {
                    this.xMovement = SnakeConfig.GRID_SIZE;
                    this.yMovement = 0;
                }
                break;
                case DOWN: {
                    this.xMovement = 0;
                    this.yMovement = SnakeConfig.GRID_SIZE;
                }
                break;
            }
            this.currentDirection = direction;
        }

    }

    public int getOppositeDirection(int direction)
    {
        for (int i = 1; i <= 2; i++)
        {
            direction += 1;
            if (direction >= 5)
            {
                direction = 1;
            }
        }
        return direction;
    }

    public void newSegment(Point p)
    {
        body.add(p);
        this.gamePanel.map.put(p, this);

    }

    public void newSegment(Point p, int index)
    {
        body.add(index, p);
        this.gamePanel.map.put(p, this);
    }


    public void removeSegment(int index)
    {
        this.gamePanel.map.remove(this.body.get(index));
        this.body.remove(index);
    }

    public int getNumberOfSegments()
    {
        return this.body.size();
    }


    public void setGrowth(boolean b)
    {
        this.growSnake = b;
    }


    public void draw(Graphics g)
    {
        g.setColor(this.col);
        for (int i = 0; i < this.body.size(); i++ )
        {
            g.fillRect(this.body.get(i).x, this.body.get(i).y, SnakeConfig.GRID_SIZE, SnakeConfig.GRID_SIZE);
        }
    }

    @Override
    public void reactToKey(KeyEvent e) {
        System.out.println("Snake received Key: " + e.getKeyCode());
        int key = e.getKeyCode();
        if ( key == leftKey )  { this.changeDirection(Snake.LEFT); }
        if ( key == upKey )    { this.changeDirection(Snake.UP); }
        if ( key == rightKey ) { this.changeDirection(Snake.RIGHT); }
        if ( key == downKey )  { this.changeDirection(Snake.DOWN); }

    }
}
