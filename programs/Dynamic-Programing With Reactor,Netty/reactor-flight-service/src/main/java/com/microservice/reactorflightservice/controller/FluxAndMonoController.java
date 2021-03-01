package com.microservice.reactorflightservice.controller;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FluxAndMonoController {

    @GetMapping("/flux")
    public Flux<Integer> getFlux(){
        return Flux.just(1,2,3)
                   .delayElements(Duration.ofSeconds(1))
                   .log();
    }
    @GetMapping("/mono")
    public Mono<Integer> getMono(){
        return Mono.just(1)
                   .log();
    }
    
    @GetMapping(value="/flux-stream",produces=org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> getFluxStream(){
        return Flux.just(1,2,3,4,5,6,7)
                   .delayElements(Duration.ofSeconds(1))
                   .log();
    }
}
