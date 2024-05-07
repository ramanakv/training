package com.sealed;

public final class Circle implements Shape {

	
	private double radius;
	
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI*radius*radius;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return Math.PI*2*radius;
	}

}
