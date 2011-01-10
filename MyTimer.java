package de.martin_ueding.spiel.cornflakes;

// Copyright (c) 2009 Martin Ueding [mu@martin-ueding.de]

import java.util.TimerTask;

/**
 * Laesst das Fenster neu Zeichnen.
 *
 * Copyright: Martin Ueding ;-)
 */

public class MyTimer extends TimerTask {
	public void run() {
		Corn.f.repaint();
	}
}
