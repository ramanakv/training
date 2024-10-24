package factorypatternproject;

import java.util.ResourceBundle;

public class CountryFactory {

	private CountryFactory() {	}

	public static Country getCountry(String code) {

		ResourceBundle rd = ResourceBundle.getBundle("country");

		String data = rd.getString(code);

		String[] values = data.split(":");

		Country country = new CountryImpl(values[0], values[1], Double.parseDouble(values[2]));
		return country;
	}

	private static class CountryImpl implements Country {

		private String countryCode;
		private String currency;
		private double conversionRate;

		public CountryImpl(String countryCode, String currency, double conversionRate) {
			super();
			this.countryCode = countryCode;
			this.currency = currency;
			this.conversionRate = conversionRate;
		}

		@Override
		public String getCountryCode() {
			return countryCode;
		}

		@Override
		public String getCurrency() {

			return currency;
		}

		@Override
		public double getConversionRate() {

			return conversionRate;
		}

	}

}
