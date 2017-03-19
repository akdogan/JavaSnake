package com.caakdogan.snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
public class SnakeKeyListener implements KeyListener
{
    ArrayList<KeyReceiver> receivers;
    public SnakeKeyListener(KeyReceiver receiver)
    {
        this.receivers = new ArrayList<KeyReceiver>();
        this.addReceiver(receiver);
    }

    public SnakeKeyListener()
    {
        this.receivers = new ArrayList<KeyReceiver>();
    }

    public void addReceiver(KeyReceiver newReceiver)
    {
        this.receivers.add(newReceiver);
    }

    public void removeReceiver(KeyReceiver receiverToRemove)
    {
        if (this.receivers != null && this.receivers.size() > 0)
        {
            for (int i = 0; i < this.receivers.size(); i++)
            {
                if (receivers.get(i).equals(receiverToRemove));
                {
                    receivers.remove(i);
                }
            }
        }
    }

    public void clearReceivers()
    {
        this.receivers.clear();
    }




    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < receivers.size(); i++)
        {
            receivers.get(i).reactToKey(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
