package com.caakdogan.snake;

import java.awt.*;

// receive an object (any, or possible types that can get involved
// Alternatively, different objects contained

// Caller can add all necessary objects (from the menupane), that could get modified by an action

// For every possibility, there is an extra class itemmenu
// e.g. for starting the game it would be menuitemactionstartgame
// react method would call game.initialize(number of players)
// --> this would need an general int value in the object to put the information

// For selecting colors: (Menu item schould contain possible color modifier

// Instead of returning a value, the value is stored in the menuitem object
// The caller can take information out of the object thats relevant / required

//Create Abstract class that has all the selection and regular logic
// only the react to action is abstract
// Every type of menuitem must implement it

/**
 * Created by Arif-Admin on 17.03.2017.
 */
public class MenuItemStartGame extends MenuItem{
    // Item Related
    private String label;
    private boolean selected;
    private Color color;
    private Font font;

    // Action related
    private int numberOfPlayers;
    private MainMenuPanel menu;

    public MenuItemStartGame(String label, int x, int y, boolean selected, int numberOfPlayers, MainMenuPanel menu)
    {
        super(label, x, y, selected);
        this.numberOfPlayers = numberOfPlayers;
        this.menu = menu;
    }

    public void performAction(int key) {
        if (key == 10) {
            this.menu.startGame(this.numberOfPlayers);
        }
    }



}
