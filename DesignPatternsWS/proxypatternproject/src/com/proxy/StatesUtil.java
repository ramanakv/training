package com.proxy;

public class StatesUtil {

	public String getCapital(String state) {
		// assume that the data extracted from database or a remote machine

		switch (state.toLowerCase()) {
		case "ap":
			return "Amaaravathi";
		case "bihar":
			return "Patna";
		case "maharashtra":
			return "Mumbai";
		case "orissa":
			return "Bhubaneshwar";
		default:
			return "Unknown";

		}
	}
}
