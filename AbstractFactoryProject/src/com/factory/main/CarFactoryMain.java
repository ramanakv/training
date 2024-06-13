package com.factory.main;


import com.factory.CarFactory;
import com.product.Engine;
import com.product.Transmission;

public class CarFactoryMain {

	public static void main(String[] args) {
		CarFactory cf = CarFactory.getFactory("maruti");
		Engine e = cf.createEngine();
		Transmission t = cf.createTransmission();

		e.makeEngine();
		t.makeTransmission();

	}

}
