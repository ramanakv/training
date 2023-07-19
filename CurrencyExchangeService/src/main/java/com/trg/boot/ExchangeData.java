package com.trg.boot;

public class ExchangeData {
	
	String fromCurrency;
	String toCurrency;
	double amount;
	double convertedvalue;

	public ExchangeData() {
		super();
	}

	public ExchangeData(String fromCurrency, String toCurrency, double amount, double convertedvalue) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.amount = amount;
		this.convertedvalue = convertedvalue;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromcurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getConvertedvalue() {
		return convertedvalue;
	}

	public void setConvertedvalue(double convertedvalue) {
		this.convertedvalue = convertedvalue;
	}

}
