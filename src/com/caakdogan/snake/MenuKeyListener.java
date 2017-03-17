package com.caakdogan.snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Arif-Admin on 09.03.2017.
 */
public class MenuKeyListener implements KeyListener {

    GameField game;
    public MenuKeyListener(GameField game)
    {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());

        switch(e.getKeyCode())
        {
            case 80: game.initialize();
                break;
            case 81: System.out.println("andere Taste");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
