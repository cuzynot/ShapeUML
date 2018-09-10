
public class Enemy extends Square implements Moveable{
	
	Enemy(double x, double y, double height, double width){
		super(x, y, height, width);
	}
	
	@Override
	public void moveUp() {
		setY(getY() + 10);
	}

	@Override
	public void moveDown() {
		setY(getY() - 10);
	}

	@Override
	public void moveLeft() {
		setX(getX() - 10);
	}

	@Override
	public void moveRight() {
		setX(getX() + 10);
	}

}
