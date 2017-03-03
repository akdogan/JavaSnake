package com.timer;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
import javax.swing.*;
import java.util.TimerTask;
import java.util.ArrayList;
class TimedDraw extends TimerTask
{
    DrawPanel TimerCanvas;

    JFrame f;
    public TimedDraw(DrawPanel TimerCanvas, JFrame f)
    {
        this.TimerCanvas = TimerCanvas;

        this.f = f;
    }


    @Override public void run()
    {
        f.repaint();
    }
}
