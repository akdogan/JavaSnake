package com.timer;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
import javax.swing.*;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Random;

class TimedMove extends TimerTask
{

    ArrayList<Snake> TimerSnakes;

    public TimedMove(ArrayList<Snake> TimerSnakes)
    {

        this.TimerSnakes = TimerSnakes;

    }


    @Override public void run()
    {
        //moveSnakeRandomly();
        TimerSnakes.get(0).moveSnake();


    }

    private void moveSnakeRandomly()
    {
        Random r = new Random();
        int chanceForChange = r.nextInt(10);
        //System.out.println("ChanceForChange: " + chanceForChange);
        if (chanceForChange > 5)
        {
            //System.out.print("NEW DIRECTION: ");
            int dir = r.nextInt(4) + 1;
            //System.out.println(dir);
            this.TimerSnakes.get(0).changeDirection(dir);
        }

    }
}
