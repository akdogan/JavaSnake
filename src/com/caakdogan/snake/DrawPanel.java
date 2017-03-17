package com.caakdogan.snake;

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
           s.drawSnake(g);
        }
        // Draw the Fruits
        for (Fruit f : this.fruits)
        {
           f.draw(g);
        }
        // Draw the obstacles
        for (SnakeObstacle o : this.obstacles )
        {
            o.draw(g);
        }

    }


}
