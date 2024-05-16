package observerpatternproject;

import java.util.ArrayList;
import java.util.List;

public class NumberStore {
	int number = 100;

	List<Observer> list = new ArrayList<Observer>();

	public void register(Observer observer) {
		list.add(observer);
	}

	public void derigenter(Observer observer) {
		list.remove(observer);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
		notifyObservers();
	}

	private void notifyObservers() {
		for (Observer ob : list) {
			ob.notifyChange(this.number);
		}
	}

}
