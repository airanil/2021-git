package com.microservice.importservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ImportServiceApplication {

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		//	return new RestTemplate();
		HttpComponentsClientHttpRequestFactory httpClientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
		httpClientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(httpClientHttpRequestFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(ImportServiceApplication.class, args);
	}

}


