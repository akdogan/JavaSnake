package com.timer;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

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
            for (Iterator<SnakeSegment> i = s.getSegments(); i.hasNext();)
            {
                SnakeSegment segment = i.next();
                g.fillRect(segment.p.x, segment.p.y, 9, 9);
            }
        }
    }


}
