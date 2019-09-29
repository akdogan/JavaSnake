package com.caakdogan.snake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Arif Akdogan on 17.03.2017.
 * This is the main Window in which the menu and game is displyed.
 * Also responsible for all wrapping logic like starting the game and displaying the menu after game over
 */
class SnakeFrame extends JFrame {

    private GamePanel gamePanel; //before canvas
    private MainMenuPanel mainMenuPanel;
    public SnakeKeyListener skl; // to main, should be attached to SnakeFrame
    private JPanel currentPanel;


    public SnakeFrame(SnakeKeyListener skl)
    {
        this.skl = skl;
        this.addKeyListener(skl);
        ArrayList<String> labels = new ArrayList<String>();
        this.startMenu("Java Snakes", labels);
    }

    public void startMenu(String heading, ArrayList<String> labels)
    {
        this.mainMenuPanel = new MainMenuPanel(this, heading, labels );
        this.addNewPanel(mainMenuPanel);
        //System.out.println("MainMenuPanel added");
    }


    public void startGame(int numberOfPlayers, int speed, Color p1, Color p2, String mapName)
    {
        this.gamePanel = new GamePanel(numberOfPlayers, speed, this, p1, p2, mapName);
        this.addNewPanel(gamePanel);
        //System.out.println("gamePanel added");
    }

    public void stopGame(ArrayList<String> scores)
    {
        //System.out.println(this.getComponent(0));
        this.startMenu("Game Over", scores);

    }

    private void addNewPanel(JPanel newPanel)
    {
        if (this.currentPanel != null)
        {
            this.remove(this.currentPanel);
        }
        this.add(newPanel);
        this.currentPanel = newPanel;
        this.setVisible( true );
        this.repaint();
    }

}
