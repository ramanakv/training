package com.inherit;

public class Square implements Shape {

	private double length;

	public Square(double length) {
		super();
		this.length = length;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return length * length;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return length * 4;
	}

}
