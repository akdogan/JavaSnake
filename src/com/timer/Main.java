package com.timer;

import java.util.ArrayList;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Timer;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

		Snake player1 = new Snake(new Point(300, 300), 3, Color.BLUE);
		ArrayList<Snake> players = new ArrayList<>();
		players.add(player1);

		DrawPanel canvas = new DrawPanel(players);
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setSize( 800, 600 );

		f.addKeyListener(new KeyListener(player1));

		HashMap test = new HashMap<Point, Object>();

		f.add(canvas);
		f.setVisible( true );

		Timer timer = new Timer();
		timer.schedule( new TimedDraw(canvas, f), 1000, 50);
		timer.schedule( new TimedMove(players), 1000, 200);

	}


}
