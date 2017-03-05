package com.timer;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
import javax.swing.*;
import java.util.TimerTask;
import java.util.ArrayList;
class TimedDraw extends TimerTask
{
    JPanel screen;
    JFrame f;
    boolean continueRunning;

    public TimedDraw(JPanel screen, JFrame f)
    {
        this.screen = screen;
        this.continueRunning = true;
        this.f = f;
    }

    public void switchTaskOff()
    {
        this.continueRunning = false;
    }


    @Override public void run()
    {
        if (continueRunning)
        {

            f.repaint();
        }
        //f.repaint();

    }
}
