package com.caakdogan.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Arif-Admin on 05.03.2017.
 */
class MainMenuPanel extends JPanel implements KeyReceiver{
    ArrayList<MenuItemAction> menuItems;
    int selectedItem;
    private SnakeFrame game;
    Font font;


    public MainMenuPanel(SnakeFrame game){
        menuItems = new ArrayList<MenuItemAction>();
        menuItems.add(new MenuItemAction("1 Player Game", 1, true));
        menuItems.add(new MenuItemAction("2 Player Game", 2));
        int selectedItem = 0;
        font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        this.game = game;
        game.skl.clearReceivers();
        game.skl.addReceiver(this);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int y = 50;
        setFont(font);
        for ( MenuItemAction m : menuItems)
        {
            g.setColor(m.getColor());
            g.drawString(m.getLabel(), 50, y);
            y += 30;
        }
    }

    public void navigate(boolean navigateUp)
    {
        int direction;

        if (navigateUp)
        {
            direction = -1;
        }
        else
        {
            direction = 1;
        }

        int newSelectedItem = selectedItem;
        if (selectedItem == 0 && direction == -1)
        {
            newSelectedItem = menuItems.size()-1;
        }
        else if (selectedItem == menuItems.size()-1 && direction == 1)
        {
            newSelectedItem = 0;
        }
        else
        {
            newSelectedItem = selectedItem + direction;
        }
        menuItems.get(selectedItem).unSelect();
        menuItems.get(newSelectedItem).select();
        selectedItem = newSelectedItem;
        this.repaint();
    }

    public void reactToKey(KeyEvent e)
    {
        System.out.println(e.getKeyCode());
        switch (e.getKeyCode())
        {
            case 10: this.game.startGame(menuItems.get(selectedItem).performAction());
                break;
            case 38: this.navigate(true);
                break;/*
            case 39: s.changeDirection(Snake.RIGHT);
                break;*/
            case 40: this.navigate(false);
                break;/*
            case 83: s.setGrowth(true);
                break;
            case 88: System.out.println("BREAK");
                break;
            case 80: game.clear();
                break;
            case 89: game.increaseSpeed();
                break;*/
        }
    }
}
