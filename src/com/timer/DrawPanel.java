package com.timer;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

class DrawPanel extends JPanel {
    ArrayList<Snake> snakes;
    ArrayList<Fruit> fruits;
    public DrawPanel(ArrayList<Snake> snakes, ArrayList<Fruit> fruits)
    {
        this.snakes = snakes;
        this.fruits = fruits;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the Snakes
        for (Snake s : snakes)
        {
            g.setColor(s.getColor());
            for (int i = 0; i < s.getNumberOfSegments(); i++)
            {
                Point p = s.getSegment(i);
                g.fillRect(p.x, p.y, SnakeConfig.GRID_SIZE - 1, SnakeConfig.GRID_SIZE - 1);
            }
        }

        // Draw the Fruits
        for (Fruit f : fruits)
        {
            g.setColor(f.getColor());
            Point p = f.p;
            g.fillRect(p.x, p.y, SnakeConfig.GRID_SIZE - 1, SnakeConfig.GRID_SIZE - 1);
        }

    }


}
