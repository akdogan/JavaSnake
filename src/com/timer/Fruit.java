package com.timer;


/**
 * Created by Arif-Admin on 03.03.2017.
 */

import java.awt.*;
import java.util.Random;

public class Fruit extends GameElement {
    Point p;
    Color col;
    public Fruit(GameField map)
    {

        Point tempPoint = createPosition();
        this.p = tempPoint;
        this.col = SnakeConfig.FRUIT_STANDARD_COLOR;
        map.addValue(this.p, this);
    }



    private Point createPosition()
    {
        Random r = new Random();
        int tempX = 10* (r.nextInt((SnakeConfig.WINDOW_WIDTH / 10 - 1) + 1));
        int tempY = 10* (r.nextInt((SnakeConfig.WINDOW_HEIGHT / 10 - 1) + 1));
        return new Point(tempX, tempY);
    }

    public Color getColor() {
        return this.col;
    }
}
