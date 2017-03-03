package com.timer;

import java.awt.event.KeyEvent;

/**
 * Created by client on 03.03.2017.
 */
public class KeyListener implements java.awt.event.KeyListener
{
    private Snake snake;

    KeyListener (Snake snake)
    {
        this.snake = snake;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case 37:
                snake.changeDirection(Snake.LEFT);
                break;

            case 40:
                snake.changeDirection(Snake.DOWN);
                break;

            case 39:
                snake.changeDirection(Snake.RIGHT);
                break;

            case 38:
                snake.changeDirection(Snake.UP);
                break;

            case 83:
                snake.newSegment();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
