package com.choresp;

public class ATMMachine {

	CurrencyDispenser dispensers[] = { 
			new Currency500Dispenser(), 
			new Currency200Dispenser(),
			new Currency100Dispenser() 
			};

	public ATMMachine() {

		for (int i = 0; i < 2; i++) {
			dispensers[i].setNextDispenser(dispensers[i + 1]);
		}

	}

	public void dispense(Currency currency) {

		if (currency.getAmount() % 100 != 0)
			throw new RuntimeException("Amount should be in multiples of 100");
		
		dispensers[0].dispense(currency);
	}

}
