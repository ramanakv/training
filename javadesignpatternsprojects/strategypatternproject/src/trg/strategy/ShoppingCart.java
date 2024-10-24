package trg.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	List<Product> products = new ArrayList<Product>();
	PaymentStrategy strategy;
	
	
	public ShoppingCart(PaymentStrategy strategy) {
		super();
		this.strategy = strategy;
	}

	public void addToCart(Product p) {
		products.add(p);
	}
	
	public double getCartValue() {
		
		double totalValue=0;
		for(Product p:products) {
			totalValue += p.getQuantity()*p.getPrice();
		}
		return totalValue;
	}
	
	public void makePayment() {
		double value = getCartValue();
		strategy.pay(value);
	}
	
}
