package de.martin_ueding.spiel.cornflakes;

// Copyright (c) 2009 Martin Ueding [mu@martin-ueding.de]

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * Dieses Programm simuliert eine Packung Cornflakes, die sich in der
 * Schwerelosigkeit befinden.
 * Ein Schuss darauf wirbelt alles durcheinander.
 *
 * Copyright: Martin Ueding
 */

public class Corn {

	public static List<Flake> schachtel;
	public static int bx = 600, by=600, bix=0, biy=0;
	public static int cfx = 200, cfy = 300;
	public static JFrame f;
	public static final int radius = 5;
	public static boolean shot = false;
	public static Feld feld;

	/**
	 * Initialisiert die Flakes, setzt sie auf ihre Positionen in der Schachtel.
	 */
	private static void initFlakes() {
		int i, j;

		schachtel = new LinkedList<Flake>();

		Flake now;

		for (i = bix+(bx-cfx)/2; i < bix+(bx+cfx)/2; i+=15) {
			for (j = biy+(by-cfy)/2; j < biy+(by+cfy)/2; j+=15) {
				now = new Flake(i, j);
				schachtel.add(now);
			}
		}
	}

	public static void main(String[] args) {
		
		/* Erzeuge ein Fenster und eine Schachtel mit Flakes.
		 * Dann wird Maus und Tastatur mit Listenern verknuepft.
		 */
		 
		initFlakes();

		f = new JFrame("Cornflakes");
		f.setSize(bx, by+20);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		feld = new Feld();
		f.add(feld);

		final Timer timer = new Timer();
		timer.schedule(new MyTimer(), 0, 50);

		f.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg) {
					Flake.vInit *= Math.pow(1.05, -arg.getWheelRotation());
					
					if (Flake.vInit < 1) {
						Flake.vInit = 1;
					}
					else if (Flake.vInit > 1000000) {
						Flake.vInit = 1000000;
					}
			}
		});

		f.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			
			public void mouseReleased(MouseEvent event) {
				Iterator<Flake> it = Corn.schachtel.iterator();

				while (it.hasNext()) {
					it.next().speedUp(event.getX(), event.getY()-20);
				}
				
				shot = true;				
			}
		});

		f.addMouseMotionListener(new MyMML());

		f.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {}

			public void keyReleased(KeyEvent ev) {
				if (ev.getKeyChar() == 'n') {
					initFlakes();
					shot = false;
				}
				else if (ev.getKeyChar() == 'f') {
					Flake.vInit = Double.parseDouble(JOptionPane.showInputDialog(Spr.get("feuerkraft")+":"));
				}
			}

			public void keyTyped(KeyEvent arg0) {}
		});

		f.setVisible(true);
	}
}
