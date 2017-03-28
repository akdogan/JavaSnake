package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif Akdogan on 19.03.2017.
 * Interface wraps different kinds of Menu items into one Menu
 */
public abstract class MenuItem {

    private String label;
    private boolean selected;
    private Color color;
    private Font font;


    public MenuItem(String label, boolean selected)
    {
        this.label = label;
        this.selected = selected;
        if (selected)
        {
            this.select();
        }
        else
        {
            this.unSelect();
        }
        this.font = (new Font(Font.SANS_SERIF, Font.BOLD, 20));
    }

    public Color getColor() {
        return this.color;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void unSelect()
    {
        this.selected = false;
        this.color = SnakeConfig.MENU_ITEM_DEFAULT_COLOR;
    }
    public void select()
    {
        this.selected = true;
        this.color = SnakeConfig.MENU_ITEM_DEFAULT_SELECTED_COLOR;
    }

    abstract void performAction(int key);

    public void draw(int x, int y, Graphics g)
    {
        g.setColor(getColor());
        g.drawString(getLabel(), x, y);
    }

}
