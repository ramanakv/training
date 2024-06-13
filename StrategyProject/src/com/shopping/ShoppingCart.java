package com.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	List<Product> cart = new ArrayList<Product>();

	public void addToCart(Product p) {
		cart.add(p);
	}

	public double getCartValue() {
		double totalvalue=0;
		for(Product p: cart) {
			totalvalue = totalvalue + p.getPrice();
		}
		return totalvalue;
	}
	
	public void pay(PaymentStrategy ps ) {
		double amount = getCartValue();
		ps.pay(amount);
	}
}
