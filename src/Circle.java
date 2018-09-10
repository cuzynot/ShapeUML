
public class Circle extends Shape{
	private double radius;
	
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
