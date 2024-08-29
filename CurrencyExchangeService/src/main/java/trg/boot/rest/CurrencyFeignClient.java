package trg.boot.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-rates-service")
public interface CurrencyFeignClient {
	
	@GetMapping("getrates/{currency}")
	public Response getRateResponse( @PathVariable("currency") String currency);
	
}
