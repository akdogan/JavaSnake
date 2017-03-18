package com.caakdogan.snake;

import javax.swing.*;

/**
 * Created by Arif-Admin on 17.03.2017.
 */
public class SnakeFrame extends JFrame {

    private GamePanel gamePanel; //before canvas
    private MenuPanel gameover;
    public SnakeKeyListener skl; // to main, should be attached to SnakeFrame
    private JPanel currentPanel;

    public SnakeFrame(SnakeKeyListener skl)
    {
        this.skl = skl;
        this.addKeyListener(skl);
        this.startGame();

    }

    public void startGame()
    {
        this.gamePanel = new GamePanel(1, this);
        this.addNewPanel(gamePanel);
        System.out.println("gamePanel added");
    }

    public void stopGame(int score)
    {
        System.out.println(this.getComponent(0));
        this.gameover = new MenuPanel(score, this);
        this.addNewPanel(this.gameover);
        this.skl.clearReceivers();
        this.skl.addReceiver(gameover);
        this.gamePanel = null;
    }

    /*public void clearGame()
    {
        this.map = new HashMap<Point, GameElement>();
        this.fruits = new ArrayList<Fruit>();
        this.Timer = new java.util.Timer();
        this.f.remove(gameover);
        if (this.f.getKeyListeners() != null)
        {
            this.f.removeKeyListener(skl);
        }
        this.initialize();

    }*/

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
