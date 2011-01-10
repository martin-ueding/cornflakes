/**
 * Dies stellt ein Flakes aus der Packung dar.
 * Es besitzt Eigenschaften wie Position und Geschwindigkeit.
 *
 * Außerdem Methoden zur selbststaendigen Bewegung.
 */

public class Flake {
	
	private double x, y;
	public static final int size = 5;
	public static double vInit = 50000;
	public double vx=0, vy=0;
	public int cn;
	
	/**
	 * Konstruktor setzt Flake auf abgebene Position.
	 */
	
	public Flake (double a, double b) {
		x = a;
		y = b;
		
		cn = (int)(Math.random()*4.9);
	}
	
	/**
	 * Bewegt sich vom Zentrum des Einschusses weg.
	 */
	
	public void move () {

		x += vx;
		y += vy;
		
		vy += 0.05;
	}
	
	/**
	 * Setzt das Zentrum auf den neuen Wert und die Geschwindigkeit
	 * wird wieder auf Ursprung gesetzt.
	 */
	
	public void speedUp (int a, int b) {
		double alpha = Math.atan((y-b)/(x-a));
		if (a > x)
			alpha += Math.PI;
		
		vx += vInit/10000*Math.cos(alpha);
		vy += vInit/10000*Math.sin(alpha);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

}
