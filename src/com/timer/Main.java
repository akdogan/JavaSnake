package com.timer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.*;
import java.util.Timer;
import java.awt.Graphics;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

		Snake player1 = new Snake(new Point(300, 300), 3, Color.BLUE);
		//Snake player2 = new Snake(10, 10, 50, Color.ORANGE);
		ArrayList<Snake> players = new ArrayList<Snake>();
		players.add(player1);
		//players.add(player2);

		DrawPanel canvas = new DrawPanel(players);
		JFrame f = new JFrame();
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setSize( 800, 600 );
		f.add(canvas);
		f.setVisible( true );
		SnakeKeyListener sKL = new SnakeKeyListener(player1);
		f.addKeyListener(sKL);

		Timer timer = new Timer();
		timer.schedule( new TimedDraw(canvas, f), 1000, 50);
		timer.schedule( new TimedMove(players), 1000, 200);

	}


}
