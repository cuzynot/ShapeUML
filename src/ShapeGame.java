
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeGame extends JFrame{
	
	

	public static void main(String[] args) {

	}
	
	// inner class of panel to draw contents
	class GameAreaPanel extends JPanel{
		
	}

	// inner class to get keyboard input
	class MyKeyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
		
	}
}
