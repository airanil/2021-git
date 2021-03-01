package com.microservice.reactorflightservice;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;



@WebFluxTest
public class FlightControllerTest {
    
    @Autowired
    WebTestClient webTestClient;

    @Test
    public void flux_approach1(){
        Flux<Integer> integerFlux=webTestClient.get().uri("/flux")
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .exchange()
        .expectStatus().isOk()
        .returnResult(Integer.class)
        .getResponseBody();

        StepVerifier.create(integerFlux)
        .expectSubscription()
        .expectNext(1)
        .expectNext(2)
        .expectNext(3)
        .verifyComplete();
    }


    @Test
    public void flux_approach2(){
       webTestClient.get().uri("/flux")
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .exchange()
        .expectStatus().isOk()
        .expectHeader()
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .expectBodyList(Integer.class)
        .hasSize(3);       
    }

    @Test
    public void flux_approach3(){
        List<Integer> expectedList=Arrays.asList(1,2,3,4);

        EntityExchangeResult<List<Integer>> entityExchangeResult =  webTestClient
                .get().uri("http://localhost:6001/flightTest2/flux-stream")
              //  .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Integer.class)
                .returnResult();       

        assertEquals(expectedList, entityExchangeResult.getResponseBody());
    }

    @Test
    public void flux_approach4(){
        List<Integer> expectedList=Arrays.asList(1,2,3);

        webTestClient
            .get().uri("/flux")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(Integer.class)
            .consumeWith((response)->{
                assertEquals(expectedList, response.getResponseBody());
            });    

    }
    
}










