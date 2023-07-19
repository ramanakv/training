package com.trg.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyExchangeService2Application {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeService2Application.class, args);
	}

}
