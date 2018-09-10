
public class Square extends Shape{
	private double height, width;
	
	Square(double x, double y, double width, double height){
		super(x, y, width, height);
		this.height = height;
		this.width = width;
	}
	
	
	/////////////////////Methods////////////////////
	public double getArea(){
		return (this.height*this.width);
	}
	
	public double getWidth(){
		return this.width;
	}

	public double getHeight(){
		return this.height;
	}
	
	public void setHeight(double num){
		this.height = num;
	}
	
	public void setWidth(double num){
		this.width = num;
	}
}
