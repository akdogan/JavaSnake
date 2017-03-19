package com.caakdogan.snake;

import java.awt.event.KeyEvent;

/**
 * Created by Arif Akdogan on 18.03.2017.
 * Interface to enable different KeyEventReceivers to be registered in the KeyListener
 */
public interface KeyReceiver {

    void reactToKey(KeyEvent e);
}
