package com.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	List<Item> cart = new ArrayList<>();
	
	public void addItem(Item item) {
		cart .add(item);
	}
	
	public void removeItem(Item item) {
		cart.remove(item);
	}
	
	public double calculateCost() {
		double totalCost = 0;
		for(Item item: cart) {
			totalCost =  totalCost + item.getPrice();
		}
		
		return totalCost;
	}

	public void pay(PaymentStrategy paymentMethod) {
		double cost = calculateCost();
		paymentMethod.pay(cost);
	}
}
