package com.proxy;

public class StatesUtil implements States {

	@Override
	public String getCapital(String state) {

		// uses database to get capitals for states
		switch (state.toUpperCase()) {
		case "AP":
			return "Amaravathi";
		case "BIHAR":
			return "Patna";
		case "UP":
			return "Lucknow";
		case "NAGALAND":
			return "Kohima";

		default:
			return "Unknown";
		}
	}

}
