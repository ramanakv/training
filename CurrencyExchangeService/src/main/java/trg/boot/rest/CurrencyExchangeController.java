package trg.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController

public class CurrencyExchangeController {
	@Autowired
	RestTemplate template;

	@Autowired
	WebClient.Builder builder;

	@Autowired
	CurrencyFeignClient feign;

	@GetMapping("convertwithRT/{amount}/{symbol}")
	public ConversionData getConversionDataUsingRestTemplate(@PathVariable("amount") double amount,
			@PathVariable("symbol") String currency) {

		Response resp = template.getForObject("http://currency-rates-service/getrates/{currency}", Response.class,
				currency);

		double rate = resp.rate();
		String address = resp.address();
		double value = amount * rate;
		return new ConversionData(currency, amount, rate, value, address);

	}

	@GetMapping("convertwithWC/{amount}/{symbol}")
	public ConversionData getConversionDataUsingWebClient(@PathVariable("amount") double amount,
			@PathVariable("symbol") String currency) {

		Response resp = builder.build().get().uri("http://currency-rates-service/getrates/{currency}", currency)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Response.class).block();

		double rate = resp.rate();
		String address = resp.address();
		double value = amount * rate;
		return new ConversionData(currency, amount, rate, value, address);

	}

	@GetMapping("convertwithFC/{amount}/{symbol}")
	public ConversionData getConversionDataUsingFeignClient(@PathVariable("amount") double amount,
			@PathVariable("symbol") String currency) {

		Response resp = feign.getRateResponse(currency);

		double rate = resp.rate();
		String address = resp.address();
		double value = amount * rate;
		return new ConversionData(currency, amount, rate, value, address);

	}
}
