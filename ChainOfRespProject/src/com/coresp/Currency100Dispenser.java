package com.coresp;

public class Currency100Dispenser implements CurrencyDispenser {
	CurrencyDispenser dispenser;

	@Override
	public void dispense(int amount) {
		int number = amount / 100;
		int balance = amount % 100;
		System.out.println("dispensing " + number + " 100 Rupee notes");
		
	}

	@Override
	public void setNextDispenser(CurrencyDispenser dispenser) {
		this.dispenser = dispenser;
	}

}
