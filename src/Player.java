
public class Player extends Circle implements Moveable, Scalable{

	Player(double x, double y, double radius) {
		super(x, y, radius);
	}

	@Override
	public void grow() {
		setRadius(getRadius() + 20);
	}

	@Override
	public void shrink() {
		setRadius(getRadius() + 20);
	}

	@Override
	public void moveUp() {
		setY(getY() - 10);
	}

	@Override
	public void moveDown() {
		setY(getY() + 10);
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
