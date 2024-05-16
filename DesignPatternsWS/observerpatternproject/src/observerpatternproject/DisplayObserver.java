package observerpatternproject;

public class DisplayObserver implements Observer {

	@Override
	public void notifyChange(int num) {
		System.out.println("Number value changed to " +num);
	}

}
