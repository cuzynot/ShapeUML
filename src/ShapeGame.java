//Graphics &GUI imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Color;

//Keyboard imports
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//Util
import java.util.ArrayList;


class ShapeGame extends JFrame { 
	
	// create player and enemies
	Player p;
	Enemy[] enemies = new Enemy[5];

	//class variables
	static JFrame window;
	JPanel gamePanel;


	//Main
	public static void main(String[] args) {
		window = new ShapeGame(); 
	}


	//Constructor - this runs first
	ShapeGame() { 
		super("My Game");  

		//create enemies and player
		p = new Player();

		//spawn 5 enemies

		// Set the frame to full screen 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// this.setUndecorated(true);  //Set to true to remove title bar
		//frame.setResizable(false);



		//Set up the game panel (where we put our graphics)
		gamePanel = new GameAreaPanel();
		this.add(new GameAreaPanel());

		MyKeyListener keyListener = new MyKeyListener();
		this.addKeyListener(keyListener);

		this.requestFocusInWindow(); //make sure the frame has focus   
		this.setVisible(true);
		
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}
			
			if (keyListener.pressedW) {
				p.y -= 10;
			}
			if (keyListener.pressedA) {
				p.x -= 10;
			}
			if (keyListener.pressedS) {
				p.y += 10;
			}
			if (keyListener.pressedD) {
				p.x += 10;
			}
			
			repaint();
		}


	} //End of Constructor



	/** --------- INNER CLASSES ------------- **/

	// Inner class for the the game area - This is where all the drawing of the screen occurs
	private class GameAreaPanel extends JPanel {
		public void paintComponent(Graphics g) {   
			// super.paintComponent(g); //required
			setDoubleBuffered(true); 

			//move enemies


			//check for collision





			//draw all squares
			g.setColor(Color.RED);
			g.fillRect(50, 50, 100, 100);


			//draw player circle
			g.setColor(Color.BLUE);
			// g.fillOval(200,200,20,20); 
			g.fillOval((int)(p.x), (int)(p.y), 20, 20); 

			//repaint();
		}
	}

	// -----------  Inner class for the keyboard listener - this detects key presses and runs the corresponding code
	private class MyKeyListener implements KeyListener {
		boolean pressedW, pressedA, pressedS, pressedD;

		public void keyTyped(KeyEvent e) {}

		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W) {  //If 'W' is pressed
				pressedW = true;
			} else if (e.getKeyCode() == KeyEvent.VK_A) {  //If 'A' is pressed
				pressedA = true;
			} else if (e.getKeyCode() == KeyEvent.VK_S) {  //If 'S' is pressed
				pressedS = true;
			} else if (e.getKeyCode() == KeyEvent.VK_D) {  //If 'D' is pressed
				pressedD = true;
			} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {  //If ESC is pressed
				System.out.println("Quitting!"); //close frame & quit
				window.dispose();
			}
		}   

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W) {  //If 'W' is pressed
				pressedW = false;
			} else if (e.getKeyCode() == KeyEvent.VK_A) {  //If 'A' is pressed
				pressedA = false;
			} else if (e.getKeyCode() == KeyEvent.VK_S) {  //If 'S' is pressed
				pressedS = false;
			} else if (e.getKeyCode() == KeyEvent.VK_D) {  //If 'D' is pressed
				pressedD = false;
			} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {  //If ESC is pressed
				System.out.println("Quitting!"); //close frame & quit
				window.dispose();
			}
		}
	} //end of keyboard listener



}