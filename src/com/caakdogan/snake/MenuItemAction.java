package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif-Admin on 17.03.2017.
 */
public class MenuItemAction implements MenuItem{

    private String label;
    private boolean selected;
    private Color color;
    private Font font;
    private int selector;

    public MenuItemAction(String label, int selector, boolean selected)
    {
        this.label = label;
        this.selector = selector;
        this.selected = selected;
        if (selected)
        {
            this.select();
        }
        this.font = (new Font(Font.SANS_SERIF, Font.BOLD, 20));
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
        this.color = SnakeConfig.MENU_ITEM_DEFAULT_SELECTED_COLOR;
    }

    public void unSelect()
    {
        this.selected = false;
        this.color = SnakeConfig.MENU_ITEM_DEFAULT_COLOR;
    }
}
