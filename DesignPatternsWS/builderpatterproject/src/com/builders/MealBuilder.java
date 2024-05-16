package com.builders;

import com.product.Meal;

public interface MealBuilder {
	
	void buildDrink();
	void buildMainCourse();
	void buildDessert();
	
	Meal getMeal();

}
