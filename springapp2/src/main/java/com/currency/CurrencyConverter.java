package com.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("converter")
public class CurrencyConverter {

	@Autowired
	private CurrencyRateProvider provider;

	public double convert(String symbol, double amount) {

		double rate = provider.getRate(symbol);

		double result = amount * rate;
		return result;
	}
}
