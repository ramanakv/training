package trg.chain;

public class DispenserOf200Rupees  implements CurrencyDispenser{
	
	CurrencyDispenser nextDispenser;
	
	public DispenserOf200Rupees(CurrencyDispenser dispenser) {
		this.nextDispenser = dispenser;
	}
	
	@Override
	public void dispense(int amount) {
		int count = amount / 200;
		int balance = amount % 200;    // 10300 
	
		
		
		if(count != 0)
			System.out.println("Dispensing "+ count + " 200 Rupee notes");
		if(balance != 0) {
			nextDispenser.dispense(balance);
		}
	}

}
