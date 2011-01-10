package de.martin_ueding.spiel.cornflakes;

// Copyright (c) 2009 Martin Ueding [mu@martin-ueding.de]

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Setzt die interne Mausposition auf die aktuelle.
 *
 * Copyright: Martin Ueding ;-)
 */

public class MyMML implements MouseMotionListener {

	public void mouseDragged(MouseEvent arg0) {}

	public void mouseMoved(MouseEvent arg0) {
		Corn.feld.rx = arg0.getX();
		Corn.feld.ry = arg0.getY()-20;
	}

}
