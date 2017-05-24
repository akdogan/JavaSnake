package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif-Admin on 24.05.2017.
 */
public abstract class MenuBlock {
    private String label;
    private Color col;
    private Font font;
    private int x;
    private int y;

    public MenuBlock(String label, Font font, Color col, int x, int y){
        this.label = label;
        this.col = col;
        this.font = font;
        this.x = x;
        this.y = y;
    }

   public void setColor(Color col){
        this.col = col;
   }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel(){
       return this.label;
    }

    public Color getColor(){
       return this.col;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void select(){
        //TODO  Dummy Method, should be refactored
    }

    public void unSelect(){
        //TODO Dummy Method, should be refactored
    }

    abstract void performAction(int key);

    public void draw(Graphics g)
    {
        g.setColor(this.col);
        g.setFont(this.font);
        g.drawString(this.label, this.x, this.y);
    }
}
