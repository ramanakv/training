package trg.strategy;

public class StrategyMain {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		
		cart.addToCart(new Product(11,"laptop",1,23000));
		
		cart.addToCart(new Product(2,"TV",1,41000));
		cart.addToCart(new Product(33,"Watch",2,1500));

		cart.makePayment(new UpiPaymentStrategy("abcd@icici.com"));
		
		
	}

}
