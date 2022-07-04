
public class Account {
	private int acno;
	private String name;
	private float balance;

	public Account(int acno, String name, float balance) {
		super();
		this.acno = acno;
		this.name = name;
		this.balance = balance;
	}

	public int getAcno() {
		return acno;
	}

	public String getName() {
		return name;
	}

	public float getBalance() {
		return balance;
	}

	public void deposit(float amt) {

		if (amt < 500) {
			System.out.println("Minimum deposit is 500");
		} else
			balance = balance + amt;
	}

	public void withdraw(float amt) {
		if (balance < amt)
			System.out.println("Insufficient balance");
		else
			balance = balance - amt;
	}

	public void showDetails() {
		System.out.println("Account Number: " + acno);
		System.out.println("Name: " + name);
		System.out.println("Balance: " + balance);
	}
}
