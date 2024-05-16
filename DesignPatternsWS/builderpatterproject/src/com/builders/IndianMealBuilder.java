package com.builders;

import com.product.Meal;

public class IndianMealBuilder implements MealBuilder {

	Meal meal;

	public IndianMealBuilder() {
		meal = new Meal();
	}

	@Override
	public void buildDrink() {
		meal.setDrink("Lemon Juice");

	}

	@Override
	public void buildMainCourse() {
		meal.setMainCourse("Biryani");

	}

	@Override
	public void buildDessert() {
		meal.setDessert("GulaabJamoon");

	}

	@Override
	public Meal getMeal() {

		return meal;
	}

}
