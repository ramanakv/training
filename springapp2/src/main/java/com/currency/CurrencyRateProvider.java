package com.currency;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CurrencyRateProvider {

	public double getRate(String symbol) {

		switch (symbol) {
		case "USD":
			return 82.3;
		case "GBP":
			return 97.3;
		case "JPY":
			return 0.59;

		default:
			return 1;
		}
	}

}
