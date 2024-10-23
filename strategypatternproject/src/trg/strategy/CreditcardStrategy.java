package trg.strategy;

public class CreditcardStrategy  implements PaymentStrategy{

	long cardno;

	public CreditcardStrategy(int cardno) {
		super();
		this.cardno = cardno;
	}

	@Override
	public void pay(double amount) {
	System.out.println(amount + " paid usning credit card "+ cardno);
		
	}
	
}
