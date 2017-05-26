package com.caakdogan.snake;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Arif-Admin on 24.03.2017.
 */
public class MenuItemSelectionColor extends MenuItemSelection<Color> {



    // Action related

    private ColorWrapper selector;


    public MenuItemSelectionColor(String label, int x, int y, boolean selected, ArrayList<Color> items, int defaultSelection, ColorWrapper selector){


        super(label, x, y, selected, items, defaultSelection);
        this.selector = selector;
        this.selector.setColor(items.get(selectedItemIndex));
    }

    private void print(){
        //System.out.println(label);
        //System.out.print("Item: " + this.selectedItem);
    }


    @Override
    public void setSelectorValue(){
        this.selector.setColor(items.get(selectedItemIndex));
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
        g.setColor(this.selector.getColor());
        g.fillRect(getX() + 145, getY() - 18, 20, 20);
    }
}
