package com.timer;

import java.awt.*;

/**
 * Created by Arif-Admin on 10.03.2017.
 */
public class SnakeObstacle extends GameElement{

    Point p;
    Color col;
    public SnakeObstacle(GameField map, Point p)
    {
        this.p = p;
        this.col = SnakeConfig.OBSTACLE_DEFAULT_COLOR;

        map.addValue(this.p, this);
    }

    public Color getColor()
    {
        return this.col;
    }
}
