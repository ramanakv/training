package trg.chain;

public class DispenserOf100Rupees implements CurrencyDispenser {
	CurrencyDispenser nextDispenser;

	public DispenserOf100Rupees(CurrencyDispenser dispenser) {
		this.nextDispenser = dispenser;
	}

	@Override
	public void dispense(int amount) {
		int count = amount / 100;
		System.out.println("Dispensing " + count + " 100 Rupee notes");
	}
}