import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Setzt die interne Mausposition auf die aktuelle.
 */

public class MyMML implements MouseMotionListener {

	public void mouseDragged(MouseEvent arg0) {}

	public void mouseMoved(MouseEvent arg0) {
		Corn.feld.rx = arg0.getX();
		Corn.feld.ry = arg0.getY()-20;
	}

}
