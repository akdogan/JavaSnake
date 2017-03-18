package com.caakdogan.snake;


/**
 * Created by Arif-Admin on 03.03.2017.
 */

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class Fruit implements GameElement {
    Point p;
    Color col;
    public Fruit(HashMap<Point, GameElement> map)
    {


        this.p = createPosition(map);
        this.col = SnakeConfig.FRUIT_STANDARD_COLOR;
        map.put(this.p, this);
    }




    private Point createPosition(HashMap<Point, GameElement> map)
    {
        Random r = new Random();
        Point tempPoint = new Point();
        do {
            tempPoint.x = SnakeConfig.GRID_SIZE * (r.nextInt((SnakeConfig.FIELD_WIDTH / SnakeConfig.GRID_SIZE - 2) + 1));
            tempPoint.y = SnakeConfig.GRID_SIZE * (r.nextInt((SnakeConfig.FIELD_HEIGHT / SnakeConfig.GRID_SIZE - 2) + 1));
        } while (map.containsKey(tempPoint));

        return tempPoint;
    }

    public Color getColor() {
        return this.col;
    }


    @Override
    public void draw(Graphics g) {
        g.setColor(this.col);
        g.fillOval(this.p.x, this.p.y, SnakeConfig.GRID_SIZE, SnakeConfig.GRID_SIZE);
    }
}
