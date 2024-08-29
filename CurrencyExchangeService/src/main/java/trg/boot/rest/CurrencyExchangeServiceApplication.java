package trg.boot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

	
	// for load balancing RestTemplate has to be a bean with @LoadBalanced annotation
	@Bean
	@LoadBalanced
	RestTemplate getTemplate() {
		return new RestTemplate();
	}
	
	
	// for load balancing WebClient.Builder has to be a bean with @LoadBalanced annotation
	@Bean
	@LoadBalanced
	WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}
}
