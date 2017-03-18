package com.caakdogan.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Arif-Admin on 05.03.2017.
 */
class MenuPanel extends JPanel implements KeyReceiver{
    private int score;
    private SnakeFrame game;

    public MenuPanel(int score, SnakeFrame game)
    {
        this.score = score;
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.drawString("GAME OVER", 50, 50);
        g.drawString("Score: " + score, 50, 80);
        g.drawString("Press any Key to play again!", 50, 110);

    }

    @Override
    public void reactToKey(KeyEvent e) {
       // clearthegame
                //reainitialize
        this.game.skl.clearReceivers();
        this.game.startGame(1);
    }
}
