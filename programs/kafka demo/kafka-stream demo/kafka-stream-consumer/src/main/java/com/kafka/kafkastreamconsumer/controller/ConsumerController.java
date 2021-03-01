package com.kafka.kafkastreamconsumer.controller;

import com.kafka.kafkastreamconsumer.model.Flight;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/kafka-stream")
@RestController
public class ConsumerController {

    @StreamListener("input")
    public void Consumer(Flight flt){
        System.out.println(flt);
    }
    
}
