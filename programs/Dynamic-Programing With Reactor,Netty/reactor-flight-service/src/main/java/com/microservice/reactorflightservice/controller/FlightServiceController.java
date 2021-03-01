package com.microservice.reactorflightservice.controller;

import java.time.Duration;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FlightServiceController {
    private WebClient client = WebClient.create("http://localhost:6002");
   
    @GetMapping(value="/flux",produces=org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> getFluxStream(){
        return Flux.just(1,2,3,4)
                   .delayElements(Duration.ofSeconds(1))
                   .log();
    }
    @GetMapping(value="/flightTest/flux-stream",produces=org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> getFluxStream1(){

        Flux<Integer> flux = client.get()
        .uri("/import/flux-stream")
        .accept(MediaType.APPLICATION_STREAM_JSON)
        .exchange()
        .flatMapMany(response -> response.bodyToFlux(Integer.class)).log();
   
        return flux;
    }
    @GetMapping(value="/flightTest2/flux-stream",produces=org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> getFluxStream2(){

        
        Flux<Integer> flux = client.get()
        .uri("/import/flux-stream")
       // .accept(MediaType.APPLICATION_JSON_UTF8)
        .retrieve()
        .bodyToFlux(Integer.class);


        return flux;
    }
    @GetMapping(value="/flightTest3/flux-stream",produces=org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> getFluxStream3(){
        
        Flux<Integer> flux = client.get()
        .uri("/import/flux-stream")
        .exchangeToFlux(response->{

            if (response.statusCode().equals(HttpStatus.OK)) {
                return response.bodyToFlux(Integer.class);
            }    
            else if (response.statusCode().is4xxClientError()) {
                return response.bodyToFlux(Integer.class);
            }
            else {
                return Flux.error(new RuntimeException("message"));
            }
            
        });

        return flux;
    }
    @GetMapping(value="/flightTest4/flux-stream",produces=org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getFluxStream4(){

        Flux<String> flux = client.get()
        .uri("/import/flux1")
        .exchangeToFlux(response->{

            if (response.statusCode().equals(HttpStatus.OK)) {
                return response.bodyToFlux(String.class);
            }    
            else if (response.statusCode().is4xxClientError()) {
                return response.bodyToFlux(String.class);
            }
            else {
                return Flux.error(new RuntimeException("message"));
            }
            
        });

        return flux;
    }


    @GetMapping(value="/flightTest1/mono",produces=org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Integer> getMono1(){
        
        Mono<Integer> mono=client
                            .get()
                            .uri("/import/mono")
                            .exchangeToMono(response->{
                               return response.bodyToMono(Integer.class);
                            });

        return mono;
    }

    
    
}
