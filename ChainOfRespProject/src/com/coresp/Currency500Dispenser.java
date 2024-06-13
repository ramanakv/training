package com.coresp;

public class Currency500Dispenser implements CurrencyDispenser {

	CurrencyDispenser dispenser;

	@Override
	public void dispense(int amount) {
		int number = amount / 500;
		int balance = amount % 500;
		if (number != 0)
			System.out.println("dispensing " + number + " 500 Rupee notes");
		if (balance != 0)
			dispenser.dispense(balance);
	}

	@Override
	public void setNextDispenser(CurrencyDispenser dispenser) {
		this.dispenser = dispenser;
	}

}
