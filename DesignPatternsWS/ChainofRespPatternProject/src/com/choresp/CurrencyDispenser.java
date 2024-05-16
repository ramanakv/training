package com.choresp;

public interface CurrencyDispenser {
	
	void setNextDispenser(CurrencyDispenser next);
	void dispense(Currency currency);
}

