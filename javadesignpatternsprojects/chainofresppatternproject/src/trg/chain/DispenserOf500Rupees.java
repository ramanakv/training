package trg.chain;

public class DispenserOf500Rupees implements CurrencyDispenser{

	CurrencyDispenser nextDispenser;
	

	public DispenserOf500Rupees(CurrencyDispenser dispenser) {
		this.nextDispenser = dispenser;
	}
	
	@Override
	public void dispense(int amount) {
		int count = amount / 500;
		int balance = amount % 500;    
	
		if(count != 0)
			System.out.println("Dispensing "+ count + " 500 Rupee notes");
		if(balance != 0) {
			nextDispenser.dispense(balance);
		}
	}
	


}
