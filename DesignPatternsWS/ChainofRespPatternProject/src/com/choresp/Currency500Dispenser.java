package com.choresp;

public class Currency500Dispenser implements CurrencyDispenser {

	private CurrencyDispenser nextdispenser;

	@Override
	public void setNextDispenser(CurrencyDispenser next) {
		nextdispenser = next;
	}

	@Override
	public void dispense(Currency currency) {
		int amount = currency.getAmount();
		if (amount >= 500) {

			int num = amount / 500;
			int balance = amount % 500;
			System.out.println("Dispensing " + num + " 500 notes");
			if (balance != 0)
				nextdispenser.dispense(new Currency(balance));
		}

		else {
			nextdispenser.dispense(currency);
		}

	}

}
