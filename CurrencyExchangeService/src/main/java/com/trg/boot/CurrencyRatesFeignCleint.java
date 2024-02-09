package com.trg.boot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "currency-rates-service")
public interface CurrencyRatesFeignCleint {

	@RequestMapping("getrates/{symbol}")
	public double getRate(@PathVariable("symbol") String currency);

}
