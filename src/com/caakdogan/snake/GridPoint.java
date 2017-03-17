package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif-Admin on 15.03.2017.
 */
public class GridPoint extends Point {


    public Point getCanvasPoint()
    {
        return new Point (this.x * SnakeConfig.GRID_SIZE, this.y * SnakeConfig.GRID_SIZE);
    }

    public int getCanvasX()
    {
        return this.x * SnakeConfig.GRID_SIZE;
    }

    public int getCanvasY()
    {
        return this.y * SnakeConfig.GRID_SIZE;
    }
}
