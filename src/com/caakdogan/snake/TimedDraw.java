package com.caakdogan.snake;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
import javax.swing.*;
import java.util.TimerTask;
import java.util.ArrayList;
class TimedDraw extends TimerTask
{
    JPanel screen;
    boolean continueRunning;

    public TimedDraw(JPanel screen)
    {
        this.screen = screen;
        this.continueRunning = true;
    }

    public void switchTaskOff()
    {
        this.continueRunning = false;
    }

    @Override public void run()
    {
        if (continueRunning)
        {
            screen.repaint();
        }
    }
}
