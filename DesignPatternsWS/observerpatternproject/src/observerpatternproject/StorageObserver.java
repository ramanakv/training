package observerpatternproject;

import java.util.ArrayList;
import java.util.List;

public class StorageObserver implements Observer {

	List<Integer> list = new ArrayList<Integer>();

	@Override
	public void notifyChange(int num) {
		list.add(num);
	}

	public void getAllNumbers() {
		System.out.print("The numbers stored: ");
		for (Integer i : list) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}

}
