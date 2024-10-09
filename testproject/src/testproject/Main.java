package testproject;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		for(long l =0; l<300000000;l++) {
		
			String x ="Alok"+"abcd";
			list.add(x);
		}
		
		System.out.println("Job completed");
		

		String s= "Hello".repeat(5);
		
		System.out.println(s);

	}

}
