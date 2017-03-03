package com.timer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
public class SnakeKeyListener implements KeyListener
{
    Snake s;
    public SnakeKeyListener(Snake s)
    {
        this.s = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        switch(e.getKeyCode())
        {
            case 37: s.changeDirection(Snake.LEFT);
                break;
            case 38: s.changeDirection(Snake.UP);
                break;
            case 39: s.changeDirection(Snake.RIGHT);
                break;
            case 40: s.changeDirection(Snake.DOWN);
                break;
            case 83: s.setGrowth(true);
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
