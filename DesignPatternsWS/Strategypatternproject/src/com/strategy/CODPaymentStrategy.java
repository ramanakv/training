package com.strategy;

public class CODPaymentStrategy implements PaymentStrategy {

	public void pay(double amount) {
		System.out.println("Paying "+ amount + " with cash on delivery");
	}
}
