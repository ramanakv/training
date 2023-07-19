package com.trg.boot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="RateFeign",url = "http://localhost:8082/getrate")
public interface RateFeignClent {

	@RequestMapping("{symbol}")
	public double getRate(@PathVariable("symbol")  String symbol);
}
