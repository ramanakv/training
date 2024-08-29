package trg.boot.rest;

public record ConversionData(String currency, double amount, double rate, double convertedValue,String serviceAddress) {

}
