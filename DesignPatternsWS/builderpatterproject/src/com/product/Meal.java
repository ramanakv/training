package com.product;

public class Meal {
	private String drink;
	private String mainCourse;
	private String dessert;

	public Meal() {
		super();
	}

	public Meal(String drink, String mainCourse, String dessert) {
		super();
		this.drink = drink;
		this.mainCourse = mainCourse;
		this.dessert = dessert;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getMainCourse() {
		return mainCourse;
	}

	public void setMainCourse(String mainCourse) {
		this.mainCourse = mainCourse;
	}

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

	@Override
	public String toString() {
		return "Meal [drink=" + drink + ", mainCourse=" + mainCourse + ", dessert=" + dessert + "]";
	}

}
