package com.choresp;

public class Currency100Dispenser implements CurrencyDispenser {

	@Override
	public void setNextDispenser(CurrencyDispenser next) {

	}

	@Override
	public void dispense(Currency currency) {
		int amount = currency.getAmount();

		int num = amount / 100;

		System.out.println("Dispensing " + num + " 100 notes");

	}

}
