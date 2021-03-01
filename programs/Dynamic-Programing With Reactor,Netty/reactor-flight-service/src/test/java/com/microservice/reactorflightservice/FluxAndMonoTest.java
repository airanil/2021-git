package com.microservice.reactorflightservice;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {
    

    @Test
    public void fluxTest() {

        Flux<String> stringFlux=Flux.just("first","second","third")
                                  //  .concatWith(Flux.error(new RuntimeException("error occured")))
                                    .log();

        stringFlux.subscribe(System.out::println
                            ,(e)->System.err.println(e)
                            ,()->System.out.println("Conpleted")
                            );
    }



    @Test
    public void fluxTestElement_withError (){
        Flux<String> stringFlux=Flux.just("first","second","third")
                                    .concatWith(Flux.error(new RuntimeException("error")))
                                    .log();

        StepVerifier.create(stringFlux)
                    .expectNext("first")
                    .expectNext("second")        
                    .expectNext("third")
                // .expectError(RuntimeException.class)
                    .expectErrorMessage("error")
                    .verify();

    }
    @Test
    public void fluxTestElement_withError2(){
        Flux<String> stringFlux=Flux.just("first","second","third")
                                    .concatWith(Flux.error(new RuntimeException("error")))
                                    .log();

        StepVerifier.create(stringFlux)        
                    .expectNext("first","second","third")
                    .expectError(RuntimeException.class)
                    .verify();

    }


    @Test
    public void fluxTestElementCount_withError(){
        Flux<String> stringFlux=Flux.just("first","second","third")
                                    .concatWith(Flux.error(new RuntimeException("error")))
                                    .log();

        StepVerifier.create(stringFlux)        
                    .expectNextCount(3)
                    .expectError(RuntimeException.class)
                    .verify();

    }

    @Test
    public void monoTest(){
        Mono<String> stringMono=Mono.just("first");
        StepVerifier.create(stringMono.log())
        .expectNext("first")
        .verifyComplete();

    }


    @Test
    public void monoTest_withError(){
       // Mono<String> stringMono=Mono.just("first");
        StepVerifier.create(Mono.error(new RuntimeException("error")).log())
        .expectError(RuntimeException.class)
        .verify();

    }


}
