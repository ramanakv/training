package com.trg.boot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("getrate")
public class CurrencyRateController {

	Map<String,Double> map=new HashMap<>();

	public CurrencyRateController() {
		map.put("USD", 82.3);
		map.put("JPY", 0.59);
		map.put("GBP", 96.7);
	}
	
	@RequestMapping("{symbol}")
	public double getRate(@PathVariable("symbol")  String symbol) {
		return map.get(symbol);
	}
	
	
}
