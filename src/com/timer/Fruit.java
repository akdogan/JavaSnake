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

        Point tempPoint = createPosition(map);
        this.p = tempPoint;
        this.col = SnakeConfig.FRUIT_STANDARD_COLOR;
        map.addValue(this.p, this);
    }



    private Point createPosition(GameField map)
    {
        Random r = new Random();
        Point tempPoint = new Point();
        do {
            tempPoint.x = 10* (r.nextInt((SnakeConfig.FIELD_WIDTH / 10 - 2) + 1));
            tempPoint.y = 10* (r.nextInt((SnakeConfig.FIELD_HEIGHT / 10 - 2) + 1));
        } while (map.locationHasContent(tempPoint));

        return tempPoint;
    }

    public Color getColor() {
        return this.col;
    }
}
