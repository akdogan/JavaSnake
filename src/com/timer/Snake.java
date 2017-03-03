package com.timer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Snake {
    private ArrayList<SnakeSegment> body;
    private Color col;
    private int xMovement;
    private int yMovement;

    private static final int LENGTH = 10;
    // Hardcoded hack
    private static final int MOVE = 10;

    static final int UP = 2;
    static final int DOWN = 4;
    static final int LEFT = 1;
    static final int RIGHT = 3;

    Snake(Point p, int dir, Color col) {
        this.col = col;
        body = new ArrayList<>();
        this.newSegment(p);
        this.xMovement = 0;
        this.yMovement = 0;
        this.changeDirection(dir);
    }

    void moveSnake() {

        Point temp = new Point(
            body.get(0).p.x + xMovement,
            body.get(0).p.y + yMovement
        );

        body.add(0, new SnakeSegment(temp, LENGTH));
        body.remove(body.size()-1);
    }

    /*
    Changes the direction if the Snake like this:
    1 : Left
    2 : Up
    3: Right
    4: Down
    @Param direction a value between 1 and 4;
     */
    void changeDirection(int dir) {
        switch (dir) {
            case LEFT: {
                this.xMovement = 0 - MOVE;
                this.yMovement = 0;
            }
            break;
            case UP: {
                this.xMovement = 0;
                this.yMovement = 0 - MOVE;
            }
            break;
            case RIGHT: {
                this.xMovement = MOVE;
                this.yMovement = 0;
            }
            break;
            case DOWN: {
                this.xMovement = 0;
                this.yMovement = MOVE;
            }
            break;
        }
    }

    void newSegment(Point p) {
        body.add(new SnakeSegment(p, LENGTH));
    }

    public void newSegment() {

        body.add(new SnakeSegment(body.get(body.size() - 1).p, LENGTH));
    }

    Point getSegment(int index) {
        return body.get(index).p;
    }

    Iterator<SnakeSegment> getSegments()
    {
        return body.listIterator();
    }

    Color getColor() {
        return this.col;
    }

}
