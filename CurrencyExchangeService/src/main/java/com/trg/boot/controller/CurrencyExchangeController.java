package com.trg.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.trg.boot.CurrencyRatesFeignCleint;
import com.trg.boot.beans.ExchangeData;

@RestController
@RequestMapping("exchangedata")
public class CurrencyExchangeController {

	@Autowired
	RestTemplate template;
	
	@Autowired
	CurrencyRatesFeignCleint client;

	@GetMapping("rt/{symbol}/{amount}") // amount in currency    
	public ExchangeData getcoversionDetails1(@PathVariable("symbol") String currency,@PathVariable("amount") double amount) {
		
		// for using service name directly, RestTemplate should be autowired and it should be load balanced
		double rate = template.getForObject("http://currency-rates-service/getrates/{currency}", Double.class,	currency);

		double convertedValue = amount * rate;
		return new ExchangeData(currency, "INR", amount, convertedValue);
	}
	

	@GetMapping("feign/{symbol}/{amount}") // amount in rupees
	public ExchangeData getcoversionDetails2(@PathVariable("symbol") String currency, @PathVariable("amount") double amount) {
		double rate = client.getRate(currency);
		double convertedValue = amount * rate;
		return new ExchangeData(currency, "INR", amount, convertedValue);
	}

}
