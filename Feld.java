// Copyright (c) 2010 Martin Ueding <dev@martin-ueding.de>

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;

import javax.swing.JPanel;

/**
 * Diese Klasse stellt die Cornflakes dar.
 */

public class Feld extends JPanel {
	private static final long serialVersionUID = 1L;
	private Flake now;

	public int rx, ry;

	FileInputStream fis;
	Image cfImg, bgImg;
	Image[] fImg;
	ImageObserver io = this;
	ClassLoader cl;
	
	/**
	 * Konstuktor laedt die Bilder aus dem Archiv und haelt sie im Speicher.
	 */

	public Feld () {
		cl = this.getClass().getClassLoader();
		
		fImg = new Image[5];

		try {
			cfImg = javax.imageio.ImageIO.read(cl.getResource("pic/flakes.jpg"));
			bgImg = javax.imageio.ImageIO.read(cl.getResource("pic/hintergrund.jpg"));
			
			for (int i = 0; i < 5; i++)
				fImg[i] = javax.imageio.ImageIO.read(cl.getResource("pic/flake"+i+".gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gibt die Flakes aus.
	 */

	protected void paintComponent (Graphics g) {
		g.drawImage(bgImg, 0, 0, io);

		if (Corn.shot) {
			Iterator<Flake> it = Corn.schachtel.iterator();

			while (it.hasNext()) {
				now = it.next();
				g.drawImage(fImg[now.cn], (int)now.getX(), (int)now.getY(), io);
				now.move();
			}
		}

		else
			g.drawImage(cfImg, Corn.bix+(Corn.bx-Corn.cfx)/2, Corn.biy+(Corn.by-Corn.cfy)/2, io);

		g.drawLine(Corn.bix, Corn.biy, Corn.bix, Corn.by);
		g.drawLine(Corn.bix, Corn.biy, Corn.bx, Corn.biy);
		g.drawLine(Corn.bix, Corn.by, Corn.bx, Corn.by);
		g.drawLine(Corn.bx, Corn.biy, Corn.bx, Corn.by);

		g.setColor(Color.RED);
		g.drawOval(rx-25, ry-25, 50, 50);
		g.drawLine(rx, ry-35, rx, ry+35);
		g.drawLine(rx-35, ry, rx+35, ry);
		
		g.setColor(Color.BLUE);
		g.drawString(Spr.get("feuerkraft")+": "+(int)Flake.vInit, 10, 30);
	}
}
