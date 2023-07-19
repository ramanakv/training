package com.trg.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("exchangevalue")
public class CurrencyExchangeController {
	
	@Autowired
	RestTemplate template;
	
	@RequestMapping("{symbol}/{amount}")
	public  ExchangeData getExchageDetails(@PathVariable String symbol, @PathVariable double amount) {
		
		double rate = template.getForObject("http://rate-service/getrate/{sym}", Double.class, symbol);
		double covertedValue=amount*rate;
		
		ExchangeData data = new ExchangeData(symbol,"INR",amount, covertedValue);
		
		return data;
	}

}
