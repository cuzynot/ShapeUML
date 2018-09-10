//Graphics &GUI imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
//Keyboard imports
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


class ShapeGame extends JFrame { 

	// create player and enemies
	Player p;
	ArrayList<Enemy> enemies;

	//class variables
	static JFrame window;
	JPanel gamePanel;

	// key listener
	MyKeyListener keyListener;


	//Main
	public static void main(String[] args) {
		window = new ShapeGame(); 
	}


	//Constructor - this runs first
	ShapeGame() { 
		super("My Game");  

		//create enemies and player
		p = new Player(0, 0, 50);

		//spawn 5 enemies
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		enemies = new ArrayList<Enemy>();
		enemies.add(new Enemy(randNum(50, width), randNum(50, height), 30, 30));


		// Set the frame to full screen 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// this.setUndecorated(true);  //Set to true to remove title bar
		//frame.setResizable(false);



		//Set up the game panel (where we put our graphics)
		gamePanel = new GameAreaPanel();
		this.add(new GameAreaPanel());

		keyListener = new MyKeyListener();
		this.addKeyListener(keyListener);

		this.requestFocusInWindow(); //make sure the frame has focus   
		this.setVisible(true);

		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}

			playerMovement();


			repaint();
		}


	} //End of Constructor
	
	double randNum(int min, int max) {
		return Math.random() * max + min;
	}

	void playerMovement() {
		if (keyListener.pressedW) {
			p.moveUp();
		}
		if (keyListener.pressedA) {
			p.moveLeft();
		}
		if (keyListener.pressedS) {
			p.moveDown();
		}
		if (keyListener.pressedD) {
			p.moveRight();
		}
	}

	void enemyMovement() {
		for (Enemy e : enemies) {
			int rand = (int) (randNum(0, 4));
			if (rand == 0) {
				e.moveUp();
			} else if (rand == 1) {
				e.moveLeft();
			} else if (rand == 2) {
				e.moveDown();
			} else {
				e.moveRight();
			}
		}
	}



	/** --------- INNER CLASSES ------------- **/

	// Inner class for the the game area - This is where all the drawing of the screen occurs
	private class GameAreaPanel extends JPanel {
		public void paintComponent(Graphics g) {   
			// super.paintComponent(g); //required
			setDoubleBuffered(true); 

			//move enemies


			//check for collision
//			for (Enemy e : enemies) {
//				if ()
//			}




			//draw all squares
			g.setColor(Color.RED);
			g.fillRect(50, 50, 30, 30);


			//draw player circle
			g.setColor(Color.BLUE);
			g.fillOval((int)(p.getX()), (int)(p.getY()), 50, 50); 

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