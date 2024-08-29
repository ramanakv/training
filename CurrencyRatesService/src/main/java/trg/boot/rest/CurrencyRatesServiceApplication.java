package trg.boot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyRatesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyRatesServiceApplication.class, args);
	}

}
