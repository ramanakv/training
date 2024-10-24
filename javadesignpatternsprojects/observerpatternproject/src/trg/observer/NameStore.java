package trg.observer;

import java.util.HashSet;
import java.util.Set;

public class NameStore {

	private String name;

	Set<Observer> observers = new HashSet<>();

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void setname(String name) {
		this.name = name;

		for (Observer obs : observers) {
			obs.processChange(name);
		}
	}

}
