package com.kafka.kafkastreamproducer.controller;

import com.kafka.kafkastreamproducer.model.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/kafka-stream")
@RestController
public class ProducerController {

    @Autowired
   private MessageChannel output;

    @GetMapping("/produce/string/{message}")
    public Flight  produce(@PathVariable("message") String message){

        Flight flight=new Flight("id","SQ","org","dest",message);
        output.send(MessageBuilder.withPayload(flight).build());
        return flight;

    }
    
}
