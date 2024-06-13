package com.coresp;

public class Currency1000Dispenser implements CurrencyDispenser {

	CurrencyDispenser dispenser;

	@Override
	public void dispense(int amount) {

		int number = amount / 1000;
		int balance = amount % 1000;
		if (number != 0)
			System.out.println("dispensing " + number + " 1000 Rupee notes");

		if (balance != 0)
			dispenser.dispense(balance);

	}

	@Override
	public void setNextDispenser(CurrencyDispenser dispenser) {
		this.dispenser = dispenser;
	}

}
