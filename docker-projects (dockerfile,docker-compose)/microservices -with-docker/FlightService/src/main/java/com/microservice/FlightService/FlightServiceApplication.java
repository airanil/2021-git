package com.microservice.FlightService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHystrix
public class FlightServiceApplication {

	@Bean("default")	
   // @Primary     // if conflict will come with two depandancy it will take by default
	public RestTemplate getRestTemplate1(){
		//	return new RestTemplate();
		HttpComponentsClientHttpRequestFactory httpClientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
		httpClientHttpRequestFactory.setConnectTimeout(6000);
		return new RestTemplate(httpClientHttpRequestFactory);
	}

	@LoadBalanced
	@Bean("withLoadBalance")	
	public RestTemplate getRestTemplate2(){
			return new RestTemplate();
		// HttpComponentsClientHttpRequestFactory httpClientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
		// httpClientHttpRequestFactory.setConnectTimeout(6000);
		// return new RestTemplate(httpClientHttpRequestFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(FlightServiceApplication.class, args);
	}

}
