package switchcaseproject;

public class Main1 {

	public static void main(String[] args) {

		showDayName(4);
	}

	static void showDayName(int day) {

		String name = 
				
	switch (day) {
		case 1 -> "Sunday";
		case 2 -> "Monday";
		case 3 -> "Tuesday";
		case 4 -> "Wednesday";
		case 5 -> "Thursday";
		case 6 -> "Friday";
		case 7 -> "Saturday";
		default -> "Invalid value";

		};

		System.out.println(name);

	}

}
