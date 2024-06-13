package com.shopping;

public class CreditCardPaymentStrategy implements PaymentStrategy {

	private String name;
	private int cardNumber;

	public CreditCardPaymentStrategy(String name, int cardNumber) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
	}

	@Override
	public void pay(double amount) {
		System.out.println(amount + " paid with card number " + cardNumber + " owned by " + name);
	}

}
