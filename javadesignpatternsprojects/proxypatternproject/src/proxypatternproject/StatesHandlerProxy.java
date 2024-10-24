package proxypatternproject;

import java.util.HashMap;
import java.util.Map;

public class StatesHandlerProxy implements Handler {

	
	StatesHandler sh = new StatesHandler();
	
	Map<String,String> data = new HashMap<>();
	
	@Override
	public String getCapital(String state) {
		
		if(data.containsKey(state)) {
			System.out.println("Reply for "+state + " from proxy");
			return data.get(state);
		}
		
		String capital = sh.getCapital(state);
		data.put(state, capital);
		return capital;
	}

}
