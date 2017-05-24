package com.caakdogan.snake;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by Arif-Admin on 10.03.2017.
 */
public class SnakeObstacle implements GameElement{

    GridPoint p;
    Color col;
    public SnakeObstacle(HashMap<GridPoint, GameElement> map, GridPoint p)
    {
        this.p = p;
        this.col = SnakeConfig.OBSTACLE_DEFAULT_COLOR;

        map.put(this.p, this);
    }

    public Color getColor()
    {
        return this.col;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.col);
        g.fillRect(this.p.getCanvasX(), this.p.getCanvasY(), SnakeConfig.GRID_SIZE, SnakeConfig.GRID_SIZE);
    }
}
