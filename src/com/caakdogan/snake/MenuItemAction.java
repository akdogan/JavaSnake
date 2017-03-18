package com.caakdogan.snake;

import java.awt.*;
import java.awt.MenuItem;

/**
 * Created by Arif-Admin on 17.03.2017.
 */
public class MenuItemAction {

    public String label;
    public boolean selected;
    public Color color;
    public int selector;

    public MenuItemAction(String label, int selector, boolean selected)
    {
        this.label = label;
        this.selector = selector;
        this.selected = selected;
        if (selected)
        {
            this.select();
        }
    }

    public MenuItemAction(String label, int selector)
    {
        this.label = label;
        this.selector = selector;
        this.selected = false;
        this.unSelect();
    }

    public int performAction() {
        return selector;
    }

    public String getLabel() {
        return this.label;
    }

    public Color getColor() {
        return this.color;
    }

    public void select()
    {
        this.selected = true;
        this.color = SnakeConfig.MENU_ITEM_DEFAUL_SELECTED_COLOR;
    }

    public void unSelect()
    {
        this.selected = false;
        this.color = SnakeConfig.MENU_ITEM_DEFAULT_COLOR;
    }
}
