package trg.strategy;

public class UpiPaymentStrategy implements PaymentStrategy{
	
	private String upiId;

	public UpiPaymentStrategy(String upiId) {
		super();
		this.upiId = upiId;
	}

	@Override
	public void pay(double amount) {
		System.out.println(amount + " paid with upi id "+ upiId);
		
	}

}
