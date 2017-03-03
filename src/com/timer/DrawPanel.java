package com.timer;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

class DrawPanel extends JPanel {
    ArrayList<Snake> snakes;
    public DrawPanel(ArrayList<Snake> snakes)
    {
        this.snakes = snakes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Snake s : snakes)
        {

            g.setColor(s.getColor());
            for (int i = 0; i < s.getNumberOfSegments(); i++)
            {
                Point p = s.getSegment(i);
                g.fillRect(p.x, p.y, 9, 9);
            }

        }

    }


}
