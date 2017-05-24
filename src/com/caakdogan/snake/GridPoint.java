package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif Akdogan on 15.03.2017.
 * Class to abstract the Grid from the actual pixels
 */
public class GridPoint extends Point {

    public GridPoint(int x, int y){
        super(x, y);
    }

    public GridPoint(){
        super();
    }

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
