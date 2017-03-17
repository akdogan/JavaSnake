package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif-Admin on 10.03.2017.
 */
public class SnakeObstacle implements GameElement{

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

    @Override
    public void draw(Graphics g) {
        g.setColor(this.col);
        g.fillRect(this.p.x, this.p.y, SnakeConfig.GRID_SIZE, SnakeConfig.GRID_SIZE);
    }
}
