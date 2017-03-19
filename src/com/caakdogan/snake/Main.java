package com.caakdogan.snake;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {

		SnakeKeyListener skl = new SnakeKeyListener();
		SnakeFrame game = new SnakeFrame(skl);
		game.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		game.setSize( SnakeConfig.WINDOW_WIDTH, SnakeConfig.WINDOW_HEIGHT );
		game.setVisible(true);
	}
	
}
