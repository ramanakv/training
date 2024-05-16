package com.builders;

import com.product.Meal;

public class ChineseMealBuilder implements MealBuilder {

	Meal meal;

	public ChineseMealBuilder() {
		meal = new Meal();
	}

	@Override
	public void buildDrink() {
		meal.setDrink("chinese Drink");

	}

	@Override
	public void buildMainCourse() {
		meal.setMainCourse("Spicy noodles");
	}

	@Override
	public void buildDessert() {

	}

	@Override
	public Meal getMeal() {

		return meal;
	}

}
