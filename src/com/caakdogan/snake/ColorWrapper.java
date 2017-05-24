package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif-Admin on 06.05.2017.
 */
public class ColorWrapper {
    private Color col;

    public ColorWrapper(Color col){
        this.col = col;
    }

    public Color getColor(){
        return this.col;
    }

    public void setColor(Color col){
        this.col = col;
    }
}
