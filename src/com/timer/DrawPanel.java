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
    ArrayList<SnakeObstacle> obstacles;
    public DrawPanel(ArrayList<Snake> snakes, ArrayList<Fruit> fruits, ArrayList<SnakeObstacle> obstacles)
    {
        this.snakes = snakes;
        this.fruits = fruits;
        this.obstacles = obstacles;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the Snakes
        for (Snake s : this.snakes)
        {
            g.setColor(s.getColor());
            for (int i = 0; i < s.getNumberOfSegments(); i++)
            {
                Point p = s.getSegment(i);
                g.fillRect(p.x, p.y, SnakeConfig.GRID_SIZE , SnakeConfig.GRID_SIZE );
            }
        }

        // Draw the Fruits
        for (Fruit f : this.fruits)
        {
            g.setColor(f.getColor());
            Point p = f.p;
            g.fillRect(p.x, p.y, SnakeConfig.GRID_SIZE, SnakeConfig.GRID_SIZE);
        }

        // Draw the obstacles
        for (SnakeObstacle o : this.obstacles )
        {
            g.setColor(o.getColor());
            Point p = o.p;
            g.fillRect(p.x, p.y, SnakeConfig.GRID_SIZE, SnakeConfig.GRID_SIZE);
        }

    }


}
