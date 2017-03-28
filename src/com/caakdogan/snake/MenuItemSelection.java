package com.caakdogan.snake;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Arif-Admin on 23.03.2017.
 */
public class MenuItemSelection<T> extends MenuItem {
    private String labelBase;
    /*private boolean selected; // instance variables don't seem to be required more than once
    private Color color;
    private Font font;
    private String label;*/

    // Action related
    private ArrayList<T> items; // TODO replace with generic Array
    private int selectedItemIndex;
    private T selector;
    private MainMenuPanel menu;


    public MenuItemSelection(String label, boolean selected, ArrayList<T> items, int defaultSelection, T selector, MainMenuPanel menu){

        super(label, selected);
        this.items = items;
        this.selectedItemIndex = defaultSelection;
        this.labelBase = label;
        this.menu = menu;
        //this.selector = selector;
        this.setSelectorValue();
        this.setLabel(this.labelBase + " " + (this.selectedItemIndex + 1) );
    }

    public void setSelectorValue(){
        this.menu.speed = (Integer) items.get(selectedItemIndex);
        //this.selector = items.get(selectedItemIndex);
    }

    @Override
    void performAction(int key) {
        if (key == 37) this.selectPrevious();
        else if (key == 39) this.selectNext();

    }



    void selectNext(){
        if (selectedItemIndex < items.size() - 1)
        {
            selectedItemIndex++;
        }
        else
        {
            selectedItemIndex = 0;
        }
        this.setSelectorValue();
        this.setLabel(this.labelBase + " " + (this.selectedItemIndex + 1) );    }

    void selectPrevious(){
        if (selectedItemIndex > 0)
        {
            selectedItemIndex--;
        }
        else
        {
            selectedItemIndex = items.size() - 1;
        }
        this.setSelectorValue();
        this.setLabel(this.labelBase + " " + (this.selectedItemIndex + 1) );
    }


}
