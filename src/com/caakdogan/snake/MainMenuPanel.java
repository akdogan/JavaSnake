package com.caakdogan.snake;

import com.caakdogan.shared.SnakeConfig;
import com.caakdogan.shared.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Arif Akdogan on 05.03.2017.
 * Controls the logic of the main menu
 * Needs to be split later if Menu should have depth > 1
 */
class MainMenuPanel extends JPanel implements KeyReceiver{
    private MenuList menuActionItems;
    private MenuList menuInfoLabels; //TO DO Do i need to or is one enough?
    private int selectedItem;
    private SnakeFrame game;
    private String heading;

    // Game Mutators
    private ColorWrapper p1;
    private int p1DefaultColorIndex;
    private ColorWrapper p2;
    private int p2DefaultColorIndex;
    public AtomicInteger speed;
    public SnFileName mapName;


    public MainMenuPanel(SnakeFrame game, String heading, ArrayList<String> labels){
        this.heading = heading;
        menuActionItems = new MenuList(SnakeConfig.MENU_X, SnakeConfig.MENU_START_Y, SnakeConfig.MENU_BLOCK_HEIGHT);

        this.game = game;
        ArrayList<Integer> speedSelection = new  ArrayList<Integer>();
        speedSelection.add(160);
        speedSelection.add(130);
        speedSelection.add(100);
        speedSelection.add(70);
        speedSelection.add(40);
        this.speed = new AtomicInteger(speedSelection.get(2));
        this.p1DefaultColorIndex = 0;
        this.p2DefaultColorIndex = 2;


        ArrayList<Color> colList = getListOfColors();





        this.p1 = new ColorWrapper(colList.get(p1DefaultColorIndex));
        this.p2 = new ColorWrapper(colList.get(p2DefaultColorIndex));
        menuActionItems.addMenuItem(new MenuItemStartGame(
                "1 Player Game",
                menuActionItems.getCurrentX(),
                menuActionItems.getCurrentY(),
                true,
                1,
                this));
        menuActionItems.addMenuItem(new MenuItemStartGame(
                "2 Player Game",
                menuActionItems.getCurrentX(),
                menuActionItems.getCurrentY(),
                false,
                2,
                this));



        FileHandler f = new FileHandler();
        ArrayList<String> mapList = f.getListOfMaps(SnakeConfig.MAPS_DIRECTORY);
        this.mapName = new SnFileName(mapList.get(0));
        // Menu Item for Level Selection
        menuActionItems.addMenuItem(new MenuItemSelectionString(
                "Map: ",
                menuActionItems.getCurrentX(),
                menuActionItems.getCurrentY(),
                false,
                mapList,
                0,
                this.mapName
        ));

        //int[] speed = {0, 1, 2, 3, 4, 5};
        menuActionItems.addMenuItem(new MenuItemSelectionInt(
                "Select Speed: ",
                menuActionItems.getCurrentX(),
                menuActionItems.getCurrentY(),
                false,
                speedSelection,
                2,
                this.speed));
        //Colors

        menuActionItems.addMenuItem(new MenuItemSelectionColor(
                "Player 1 Color:",
                menuActionItems.getCurrentX(),
                menuActionItems.getCurrentY(),
                false,
                colList,
                p1DefaultColorIndex,
                p1
        ));
        menuActionItems.addMenuItem(new MenuItemSelectionColor(
                "Player 2 Color:",
                menuActionItems.getCurrentX(),
                menuActionItems.getCurrentY(),
                false,
                colList,
                p2DefaultColorIndex,
                p2
        ));


        this.selectedItem = 0;

        this.menuInfoLabels = new MenuList(
                menuActionItems.getCurrentX(),
                menuActionItems.getCurrentY() + SnakeConfig.MENU_BLOCK_HEIGHT,
                SnakeConfig.MENU_BLOCK_HEIGHT);
        for ( int i = 0; i < labels.size(); i++)
        {
            this.menuInfoLabels.addMenuItem(new MenuItemLabel(
                    labels.get(i),
                    menuInfoLabels.getCurrentX(),
                    menuInfoLabels.getCurrentY()));
        }



        game.skl.clearReceivers();
        game.skl.addReceiver(this);
    }

    public void startGame(int numberOfPlayers){
        // Hier die benötigten Werte einfach aus dem MenuItem rausziehen;
        // Werte können dann innerhalb der MenuItems hinterlegt werden.
        this.game.startGame(numberOfPlayers, this.speed.get(), this.p1.getColor(), this.p2.getColor(), this.mapName.getFileName());

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
        this.menuActionItems.draw(g);
        this.menuInfoLabels.draw(g);
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
            newSelectedItem = this.menuActionItems.listOfMenuItems.size()-1;
        }
        else if (selectedItem == this.menuActionItems.listOfMenuItems.size()-1 && direction == 1)
        {
            newSelectedItem = 0;
        }
        else
        {
            newSelectedItem = selectedItem + direction;
        }
        this.menuActionItems.listOfMenuItems.get(selectedItem).unSelect();
        this.menuActionItems.listOfMenuItems.get(newSelectedItem).select();
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
            this.menuActionItems.listOfMenuItems.get(selectedItem).performAction(key);
            this.repaint();
        }

    }
}
