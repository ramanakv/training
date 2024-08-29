package trg.boot.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;



@RestController
//@RequestMapping("getrates")
public class CurrencyRatesController {
	
	@Value("${server.port}")
	int portNumber;
	
	Map<String, Double> rates = new HashMap<>();

	public CurrencyRatesController() {
		rates.put("USD", 82.1);
		rates.put("EUR", 92.5);
		rates.put("JPY", 0.59);  // Japanese yen
		rates.put("GBP", 197.6); // Great Britain pound
		rates.put("THB", 2.37);  // Thai Bhatt

	}

	@GetMapping("getrates/{symbol}")
	public Response getRates(@PathVariable("symbol") String currency) {
		return new Response(rates.get(currency), "Service at port: "+portNumber);
	}

}
