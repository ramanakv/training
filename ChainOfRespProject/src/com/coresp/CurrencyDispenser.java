package com.coresp;
public interface CurrencyDispenser {
	
	void dispense(int amount);
	void setNextDispenser(CurrencyDispenser dispenser);
}
