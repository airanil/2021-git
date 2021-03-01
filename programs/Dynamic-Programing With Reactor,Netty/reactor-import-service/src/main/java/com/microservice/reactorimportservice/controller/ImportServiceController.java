package com.microservice.reactorimportservice.controller;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ImportServiceController {

    @GetMapping(value = "import/flux-stream", produces = org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> getFluxStream() {
        return Flux.just(1, 2, 3, 4)
                   .delayElements(Duration.ofSeconds(1))
                   .log();
    }
    @GetMapping(value = "/import/flux2", produces = org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getFlux2() {
        List<String> words = Arrays.asList("the", "quick", "brown");
        Flux<String> manyLetters = Flux
                .fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE), (string, count) -> String.format(" %2d. %s", count, string))
                .delayElements(Duration.ofSeconds(1))
                .log();

        return manyLetters;
    }
    @GetMapping(value = "/import/flux1", produces = org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getFlux1() {
        List<String> words = Arrays.asList("the", "quick", "brown");
        Flux<String> manyWords = Flux
                                    .fromIterable(words)
                                    .delayElements(Duration.ofSeconds(1))
                                    .log();
        return manyWords;
    }

    @GetMapping(value = "/import/mono", produces = org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Integer> getMono1() {

        Mono<Integer> mono = Mono
                                .just(1)
                                .log();
        return mono;
    }


}
