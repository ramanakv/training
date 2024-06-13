package com.shopping;

public class StrategyMain {

	public static void main(String[] args) {

		ShoppingCart sc = new ShoppingCart();
		sc.addToCart(new Product(11, "Laptop", 45000));
		sc.addToCart(new Product(22, "headphones", 2600));

		sc.pay(new CreditCardPaymentStrategy("Ramana", 55124563));

	}

}
