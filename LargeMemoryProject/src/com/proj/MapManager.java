package com.proj;

import java.util.ArrayList;

public class MapManager {
	public void create()  {
		ArrayList<String> list = new ArrayList<>();
		int counter =0;
		while(true) {
			counter++;
			list.add("Laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaarge ".repeat(10)+counter);
			
			new String("Laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaarge ".repeat(100)+counter);
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}

}
