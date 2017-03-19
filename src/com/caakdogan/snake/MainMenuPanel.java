package com.caakdogan.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Arif Akdogan on 05.03.2017.
 * Controls the logic of the main menu
 * Needs to be split later if Menu should have depth > 1
 */
class MainMenuPanel extends JPanel implements KeyReceiver{
    private ArrayList<MenuItem> menuItems;
    private ArrayList<MenuItemLabel> labels;
    private int selectedItem;
    private SnakeFrame game;
    private String heading;



    public MainMenuPanel(SnakeFrame game, String heading, ArrayList<String> labels){
        this.heading = heading;
        menuItems = new ArrayList<>();
        this.labels = new ArrayList<>();
        menuItems.add(new MenuItemAction("1 Player Game", 1, true));
        menuItems.add(new MenuItemAction("2 Player Game", 2));
        int selectedItem = 0;

        for (String label : labels)
        {
            this.labels.add(new MenuItemLabel(label));
        }

        this.game = game;
        game.skl.clearReceivers();
        game.skl.addReceiver(this);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int y = 50;
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        g.setColor(Color.DARK_GRAY);
        g.drawString(this.heading, 50, y);
        y += 60;
        for ( MenuItem m : menuItems)
        {

            g.setColor(m.getColor());
            g.drawString(m.getLabel(), 50, y);
            y += 30;
        }
        y += 30;
        g.setColor(Color.DARK_GRAY);

        for ( MenuItemLabel l : labels)
        {
            g.drawString(l.getLabel(), 50, y);
            y += 30;
        }
    }

    private void navigate(boolean navigateUp)
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
                break;
            case 40: this.navigate(false);
                break;

        }
    }
}
