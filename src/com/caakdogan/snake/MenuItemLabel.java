package com.caakdogan.snake;


/**
 * Created by Arif-Admin on 19.03.2017.
 */
public class MenuItemLabel extends MenuBlock{


    public MenuItemLabel(String label, int x, int y)
    {
        super(label, SnakeConfig.MENU_LABEL_FONT, SnakeConfig.MENU_LABEL_COLOR, x, y);

    }

    public void performAction(int key){
        //TODO Not needed, refactor
    }

}
