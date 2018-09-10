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
	static ShapeGame window;
	JPanel gamePanel;

	// key listener
	MyKeyListener keyListener;

	// screen size
	int screenWidth;
	int screenHeight;

	//Main
	public static void main(String[] args) {
		window = new ShapeGame();
		
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}

			window.playerMovement();
			window.enemyMovement();

			// check for collision
			window.collision();


			window.repaint();
		}
	}


	//Constructor - this runs first
	ShapeGame() { 
		super("My Game");
		this.requestFocusInWindow(); //make sure the frame has focus   
		this.setVisible(true);
		// Set the frame to full screen 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		// this.setUndecorated(true);  //Set to true to remove title bar
		//frame.setResizable(false);

		//create enemies and player
		p = new Player(0, 0, 50);

		//spawn 5 enemies
		screenWidth = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		screenHeight = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight());

		enemies = new ArrayList<Enemy>();
		for (int i = 0; i < 5; i++) {
			enemies.add(new Enemy(randNum(50, screenWidth), randNum(50, screenHeight), 30, 30));
		}


		//Set up the game panel (where we put our graphics)
		gamePanel = new GameAreaPanel();
		this.add(new GameAreaPanel());

		keyListener = new MyKeyListener();
		this.addKeyListener(keyListener);

	} //End of Constructor

	double randNum(int min, int max) {
		return Math.random() * max + min;
	}

	void playerMovement() {
		if (keyListener.pressedW && p.getY() > 0) {
			p.moveUp();
		}
		if (keyListener.pressedA && p.getX() > 0) {
			p.moveLeft();
		}
		if (keyListener.pressedS && p.getY() + p.getRadius() < screenHeight) {
			p.moveDown();
		}
		if (keyListener.pressedD && p.getX() + p.getRadius() < screenWidth) {
			p.moveRight();
		}
	}

	void enemyMovement() {
		for (Enemy e : enemies) {
			int rand = (int) (randNum(0, 4));
			if (rand == 0 && e.getY() > 0) {
				e.moveUp();
			} else if (rand == 1 && e.getX() > 0) {
				e.moveLeft();
			} else if (rand == 2 && e.getY() + e.getHeight() < screenHeight) {
				e.moveDown();
			} else if (rand == 3 && e.getX() + e.getWidth() < screenWidth){
				e.moveRight();
			}
		}
	}

	void collision() {
		for (int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);
			if (Math.abs(e.getX() - p.getX()) < 20 && Math.abs(e.getY() - p.getY()) < 20) {
				enemies.remove(e);
				p.grow();
				i--;
			}
		}
	}



	/** --------- INNER CLASSES ------------- **/

	// Inner class for the the game area - This is where all the drawing of the screen occurs
	private class GameAreaPanel extends JPanel {
		public void paintComponent(Graphics g) {   
			// super.paintComponent(g); //required
			setDoubleBuffered(true);

			//draw all squares
			g.setColor(Color.RED);
			for (Enemy e : enemies) {
				g.fillRect((int)(e.getX()), (int)(e.getY()), (int)(e.getWidth()), (int)(e.getHeight()));
			}


			//draw player circle
			g.setColor(Color.BLUE);
			g.fillOval((int)(p.getX()), (int)(p.getY()), (int)(p.getRadius()), (int)(p.getRadius())); 

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
			}
		}   

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W) {  //If 'W' is released
				pressedW = false;
			} else if (e.getKeyCode() == KeyEvent.VK_A) {  //If 'A' is released
				pressedA = false;
			} else if (e.getKeyCode() == KeyEvent.VK_S) {  //If 'S' is released
				pressedS = false;
			} else if (e.getKeyCode() == KeyEvent.VK_D) {  //If 'D' is released
				pressedD = false;
			} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {  //If ESC is released
				System.out.println("Quitting!"); //close frame & quit
				window.dispose();
			}
		}
	} //end of keyboard listener



}