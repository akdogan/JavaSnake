package com.timer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Arif-Admin on 05.03.2017.
 */
class DrawMenu extends JPanel {
    private int score;


    public DrawMenu(int score)
    {
        this.score = score;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.drawString("GAME OVER", 50, 50);
        g.drawString("Score: " + score, 50, 80);

    }
}
