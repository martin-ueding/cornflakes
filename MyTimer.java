// Copyright (c) 2010 Martin Ueding <dev@martin-ueding.de>

import java.util.TimerTask;

public class MyTimer extends TimerTask {
	public void run() {
		Corn.f.repaint();
	}
}
