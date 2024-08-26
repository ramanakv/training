package trg.sf;

import org.springframework.stereotype.Component;

@Component("provider")
public class CurrencyRateProvider {

	public double getRate(String currency) {

		switch (currency) {

		case "USD":
			return 83.5;
		case "GBP":
			return 102.3;
		case "EUR":
			return 121.4;
		default:
			return 1;

		}
	}
}
