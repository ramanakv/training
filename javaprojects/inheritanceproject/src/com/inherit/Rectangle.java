package com.inherit;

public record Rectangle(double length, double width) implements Shape {

	
	public double getArea() {
		// TODO Auto-generated method stub
		return length*width;
	}


	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*(length+width);
	}

}
