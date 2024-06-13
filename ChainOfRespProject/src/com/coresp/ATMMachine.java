package com.coresp;

public class ATMMachine {

	CurrencyDispenser rootDispenser;

	public ATMMachine() {

		CurrencyDispenser d1 = new Currency1000Dispenser();
		CurrencyDispenser d2 = new Currency500Dispenser();
		CurrencyDispenser d3 = new Currency100Dispenser();

		rootDispenser = d1;
		d1.setNextDispenser(d2);
		d2.setNextDispenser(d3);
	}

	public void dispense(int amount) {

		if (amount % 100 != 0) {
			throw new RuntimeException("Amount should be in multiples of 100");
		}
		rootDispenser.dispense(amount);
	}

}
