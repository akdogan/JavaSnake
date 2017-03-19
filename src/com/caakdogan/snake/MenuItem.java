package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif Akdogan on 19.03.2017.
 * Interface wraps different kinds of Menu items into one Menu
 */
public interface MenuItem {

    Color getColor();

    String getLabel();

    void unSelect();

    void select();

    int performAction();

}
