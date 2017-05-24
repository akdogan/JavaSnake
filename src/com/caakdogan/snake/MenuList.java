package com.caakdogan.snake;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Arif-Admin on 24.05.2017.
 */
public class MenuList {
    public ArrayList<MenuBlock> listOfMenuItems;
    private int currentX;
    private int currentY;
    private int blockHeight;

    public MenuList(int startX, int startY, int blockheight){

        listOfMenuItems = new ArrayList<MenuBlock>();
        this.currentX = startX;
        this.currentY = startY;
        this.blockHeight = blockheight;
    }

    public void addMenuItem(MenuBlock m){
        this.listOfMenuItems.add(m);
        currentY += blockHeight;
    }

    public void addEmptyBlock(){
        this.addMenuItem(new MenuItemLabel("", getCurrentX(), getCurrentY() ));
    }

    public int getCurrentX(){
        return this.currentX;
    }

    public int getCurrentY(){
        return this.currentY;
    }

    public int getBlockHeight(){
        return this.blockHeight;
    }

    public int getNumberOfItems(){
        return this.listOfMenuItems.size();
    }

    public void draw(Graphics g){
        // Draw the Heading? step 2
        // For every item in the array call draw
        for ( MenuBlock m : listOfMenuItems){
            m.draw(g);
        }
    }
}
