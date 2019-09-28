package com.caakdogan.snake;

import com.caakdogan.shared.SnakeConfig;

import java.awt.*;

/**
 * Created by Arif Akdogan on 19.03.2017.
 * Interface wraps different kinds of Menu items into one Menu
 */
public abstract class MenuItem extends MenuBlock{
    private boolean selected;

    public MenuItem(String label, int x, int y, boolean selected)
    {
        super(label, SnakeConfig.MENU_ITEM_FONT, SnakeConfig.MENU_ITEM_DEFAULT_COLOR, x, y);

        this.selected = selected;
        if (selected)
        {
            this.select();
        }
        else
        {
            this.unSelect();
        }
        //this.font = (new Font(Font.SANS_SERIF, Font.BOLD, 20));
    }

    @Override
    public void unSelect()
    {
        this.selected = false;
        setColor(SnakeConfig.MENU_ITEM_DEFAULT_COLOR);
    }
    @Override
    public void select()
    {
        this.selected = true;
        setColor(SnakeConfig.MENU_ITEM_DEFAULT_SELECTED_COLOR);
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
    }

    abstract void performAction(int key);


}
