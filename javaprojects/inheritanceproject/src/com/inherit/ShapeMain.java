package com.inherit;

public class ShapeMain {

	public static void main(String[] args) {
		Rectangle r = new Rectangle(12, 10);
		Circle c = new Circle(12.5);
		Square s = new Square(12.5);

		System.out.println("Cost for Rectangle:");
		calculatCost(r);

		System.out.println("Cost for Circle:");
		calculatCost(c);

		System.out.println("Cost for Square:");
		calculatCost(s);
	}

	static void calculatCost(Shape s) {

		double area = s.getArea();
		double peri = s.getPerimeter();
		double cost = area * 2.6;

		System.out.println("Area :" + s.getArea());
		System.out.println("Perimeter: " + s.getPerimeter());
		System.out.println("Cost for devcelopment is " + cost);

	}

}
