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

    public Color p1;
    private Color p2;
    public Integer speed;


    public MainMenuPanel(SnakeFrame game, String heading, ArrayList<String> labels){
        this.heading = heading;
        menuItems = new ArrayList<>();
        this.labels = new ArrayList<>();
        this.game = game;
        menuItems.add(new MenuItemStartGame("1 Player Game", true, 1, this));
        menuItems.add(new MenuItemStartGame("2 Player Game", false, 2, this));
        ArrayList<Integer> speedSelection = new  ArrayList<Integer>();
        speedSelection.add(160);
        speedSelection.add(130);
        speedSelection.add(100);
        speedSelection.add(70);
        speedSelection.add(40);
        //int[] speed = {0, 1, 2, 3, 4, 5};
        menuItems.add(new MenuItemSelection( "Select Speed: ", false, speedSelection, 2, this.speed, this));
        //Colors
        this.p2 = Color.RED;
        menuItems.add(new MenuItemSelectionColor(
                "Player 1 Color:",
                false,
                getListOfColors(),
                this
        ));


        this.selectedItem = 0;

        for (String label : labels)
        {
            this.labels.add(new MenuItemLabel(label));
        }


        game.skl.clearReceivers();
        game.skl.addReceiver(this);
    }

    public void startGame(int numberOfPlayers){
        System.out.println("!!MainMenuPanel:" + speed);
        // Hier die benötigten Werte einfach aus dem MenuItem rausziehen;
        // Werte können dann innerhalb der MenuItems hinterlegt werden.
        this.game.startGame(numberOfPlayers, (Integer)this.speed, this.p1, this.p2);

    }

    private ArrayList<Color> getListOfColors(){
        ArrayList<Color> temp = new ArrayList<Color>();
        temp.add(Color.BLUE);
        temp.add(Color.CYAN);
        temp.add(Color.RED);
        temp.add(Color.MAGENTA);
        temp.add(Color.GREEN);
        return temp;
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
            m.draw(50, y, g);
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
        int key = e.getKeyCode();
        if (key == 38) {
            this.navigate(true);
        }
        else if (key == 40) {
            this.navigate(false);
        }
        else {
            this.menuItems.get(selectedItem).performAction(key);
            this.repaint();
        }

    }
}
