package com.trg.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CurrencyRatesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyRatesServiceApplication.class, args);
	}

}
