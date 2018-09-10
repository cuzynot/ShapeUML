import java.awt.Rectangle;

abstract public class Shape {
	private double x,y;
	private Rectangle boundingBox = new Rectangle();
	
	Shape(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	
	///////////////////////////Methods/////////////////////////////
	
	abstract public double getArea();
	
	public Rectangle getBoundingBox(){
		return this.boundingBox;
	}
	
	public void setX(double num){
		this.x = num;
	}
	
	public void setY(double num){
		this.y = num;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
}
