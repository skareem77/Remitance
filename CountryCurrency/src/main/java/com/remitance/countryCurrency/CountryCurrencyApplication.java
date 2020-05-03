package com.remitance.countryCurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class CountryCurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryCurrencyApplication.class, args);
	}

	@Bean
	public RestTemplate exchangeRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
