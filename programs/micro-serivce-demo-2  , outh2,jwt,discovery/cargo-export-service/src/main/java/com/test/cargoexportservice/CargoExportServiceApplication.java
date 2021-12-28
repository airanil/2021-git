package com.test.cargoexportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CargoExportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargoExportServiceApplication.class, args);
	}

}
