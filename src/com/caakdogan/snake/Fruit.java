package com.caakdogan.snake;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;


/**
 * Created by Arif Akdogan on 03.03.2017.
 * Class for single Fruit
 */


public class Fruit implements GameElement {
    GridPoint p;
    private Color col;

    Fruit(HashMap<GridPoint, GameElement> map)
    {
        this.p = createPosition(map);
        this.col = SnakeConfig.FRUIT_STANDARD_COLOR;
        map.put(this.p, this);
    }


    private GridPoint createPosition(HashMap<GridPoint, GameElement> map)
    {
        Random r = new Random();
        GridPoint tempPoint = new GridPoint();
        do {
            tempPoint.x = (r.nextInt(SnakeConfig.FIELD_WIDTH ));
            tempPoint.y = (r.nextInt(SnakeConfig.FIELD_HEIGHT));
        } while (map.containsKey(tempPoint));


        System.out.println("!!FRUIT OUT OF FIELD");
        System.out.println("Canvas X: " + SnakeConfig.CANVAS_WIDTH);
        System.out.println("Fruit  X: " + tempPoint.getCanvasX());
        System.out.println("Canvas Y: " + SnakeConfig.CANVAS_HEIGHT);
        System.out.println("Fruit  Y: " + tempPoint.getCanvasY());



        return tempPoint;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.col);
        g.fillOval(this.p.getCanvasX(), this.p.getCanvasY(), SnakeConfig.GRID_SIZE, SnakeConfig.GRID_SIZE);
    }
}
