package com.microservice.FlightService.controller;

import java.util.Arrays;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class FlightServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightServiceController.class);

    @Autowired
    @Qualifier("default")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("withLoadBalance")
    private RestTemplate restTemplateWthLoadBalance;

    @Value("${message: default  value}")
    public String message;

    @GetMapping("/getConfig")
    public String getConfig(){  
        return message;        
    }

    @HystrixCommand
    @GetMapping("/test")
    public String getConfig1(){    
        LOGGER.info("before hitting the service");
        HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      String response=restTemplate
                            .exchange("http://localhost:9004/getImportService", HttpMethod.GET, entity, String.class)
                            .getBody();
      
       return response;
    }


    @GetMapping("/getImportService")
    @HystrixCommand(fallbackMethod = "getImportFallBack",
    commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")
        // ,@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")
        // ,@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30")
        // ,@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000")
    })
    public String getImportService(){
        LOGGER.info("before hitting the service");
        String response=restTemplateWthLoadBalance.getForObject("http://IMPORT-SERVICE/getImportService", String.class);
        LOGGER.info("After hitting the service");
        return response;       
    }

    public String getImportFallBack(){
        return "unable to connect with server";
    }

}