package com.factory;

import com.product.Engine;
import com.product.FordEngine;
import com.product.FordTransmission;

import com.product.Transmission;

public interface CarFactory {

	Engine createEngine();

	Transmission createTransmission();

	public static CarFactory getFactory(String brand) {

		switch (brand) {
		case "maruti":
			return new MarutiFactory();
		case "ford":
			return new FordFactory();
		default:
			throw new RuntimeException("No such factory exists");
		}

	}

}

class MarutiFactory implements CarFactory {
	
	private class MarutiEngine implements Engine {

		@Override
		public void makeEngine() {
			System.out.println("This is Maruti Engine");
			
		}

	}

	private class MarutiTransmission implements Transmission {

		@Override
		public void makeTransmission() {
			System.out.println("This is Maruti Transmission");
			
		}

	}

	@Override
	public Engine createEngine() {
		return new MarutiEngine();
	}

	@Override
	public Transmission createTransmission() {
		return new MarutiTransmission();
	}

}

class FordFactory implements CarFactory {

	@Override
	public Engine createEngine() {
		return new FordEngine();
	}

	@Override
	public Transmission createTransmission() {
		return new FordTransmission();
	}

}