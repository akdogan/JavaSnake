package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
public class SnakeSegment implements GameElement{
    Point p;
    int length;
    public SnakeSegment(Point p, int length)
    {
        this.p = p;
        this.length = length;

    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(this.p.x, this.p.y, SnakeConfig.GRID_SIZE, SnakeConfig.GRID_SIZE);

    }
}
