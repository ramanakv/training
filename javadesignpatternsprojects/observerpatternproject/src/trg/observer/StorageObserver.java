package trg.observer;

import java.util.ArrayList;
import java.util.List;

public class StorageObserver implements Observer {
	List<String> list = new ArrayList<String>();

	public void processChange(String str) {

		list.add(str);
	}

	public void showAllNames() {
		
		StringBuilder output = new StringBuilder("List of names: {");
		
		 for(String name:list) {
			output.append(name + " ");
		}
		output.append("}");
		
		System.out.println(output);
		
	}

}
