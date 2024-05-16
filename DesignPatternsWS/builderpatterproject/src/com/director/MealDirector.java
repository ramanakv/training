package com.director;

import com.builders.MealBuilder;
import com.product.Meal;

public class MealDirector {

	private MealBuilder builder;

	public MealDirector(MealBuilder builder) {
		super();
		this.builder = builder;
	}

	public void makeMeal() {
		builder.buildDrink();
		builder.buildMainCourse();
		builder.buildDessert();
	}

	public Meal getMeal() {

		Meal m = builder.getMeal();
		return m;
	}

}
