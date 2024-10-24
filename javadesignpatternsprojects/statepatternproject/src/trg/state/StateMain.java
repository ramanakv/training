package trg.state;

public class StateMain {

	public static void main(String[] args) throws InterruptedException {
		FanRegulator regulator = new FanRegulator();

		while (true) {
			regulator.rotate();

			Thread.sleep(1000);
		}

	}

}
