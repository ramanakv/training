package proxypatternproject;

public class StatesHandler implements Handler {

	@Override
	public String getCapital(String state) {

		switch (state) {

		case "AP":
			return "Amaravathi";
		case "Bihar":
			return "Patna";
		case "MP":
			return "Bhopal";
		default:
			return "Unknown";

		}
	}

}
