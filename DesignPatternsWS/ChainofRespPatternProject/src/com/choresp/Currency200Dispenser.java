package com.choresp;

public class Currency200Dispenser implements CurrencyDispenser{

	private CurrencyDispenser nextdispenser;
	
	@Override
	public void setNextDispenser(CurrencyDispenser next) {
		nextdispenser = next;
		
	}

	@Override
	public void dispense(Currency currency) {
		int amount = currency.getAmount();
		if(amount >=200) {	
			int num = amount / 200;
			int balance = amount % 200;
			System.out.println("Dispensing "+ num + " 200 notes");
			if(balance != 0)
				nextdispenser.dispense(new Currency(balance));
		}
		
		else {
			nextdispenser.dispense(currency);
		}
		
		
	}

}
