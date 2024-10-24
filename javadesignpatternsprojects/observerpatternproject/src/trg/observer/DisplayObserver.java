package trg.observer;

public class DisplayObserver implements Observer {

	@Override
	public void processChange(String name) {
		System.out.println("New value for name: " + name);
	}

}
