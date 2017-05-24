package com.caakdogan.snake;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Arif-Admin on 23.03.2017.
 */
public abstract class MenuItemSelection<T> extends MenuItem {
    private String labelBase;
    public ArrayList<T> items;
    public int selectedItemIndex;



    public MenuItemSelection(String label, int x, int y, boolean selected, ArrayList<T> items, int defaultSelection){

        super(label, x, y, selected);
        this.items = items;
        this.selectedItemIndex = defaultSelection;
        this.labelBase = label;
        this.setLabel(this.labelBase + " " + (this.selectedItemIndex + 1) );
    }

    public abstract void setSelectorValue();


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
