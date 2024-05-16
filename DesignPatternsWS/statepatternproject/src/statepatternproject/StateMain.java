package statepatternproject;

import java.util.Scanner;

public class StateMain {

	public static void main(String[] args) {
		
		CeilingFan fan = new CeilingFan();
		Scanner sc = new Scanner(System.in);
		System.out.println("Keep pressing enter to change the fan state");
		while(true) {
			//System.out.println("Press Enter");
			sc.nextLine();
			fan.pullChain();
		}

	}

}
