
public class Circle extends Shape{
	
	private double radius;
	
	Circle(double x, double y, double radius) {
		super(x, y, radius * 2, radius * 2);
		setRadius(radius);
	}
	
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
}
