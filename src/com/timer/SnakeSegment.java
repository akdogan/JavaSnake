package com.timer;

import java.awt.*;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
public class SnakeSegment extends GameElement{
    Point p;
    int length;
    public SnakeSegment(Point p, int length)
    {
        this.p = p;
        this.length = length;
    }
}
