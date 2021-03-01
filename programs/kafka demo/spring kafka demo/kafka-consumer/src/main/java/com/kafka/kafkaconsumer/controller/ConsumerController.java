package com.kafka.kafkaconsumer.controller;

import com.kafka.kafkaconsumer.model.Flight;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

   @KafkaListener(topics="mytopic-string", groupId = "group_id",containerFactory = "concurrentListnerFactory")
   public void consumer(String flight){
       System.out.println(flight);
   }

   @KafkaListener(topics="mytopic-json", groupId = "group_json",containerFactory = "flightListenerFactory")
   public void consumerJson(Flight flight){
       System.out.println(flight);
   }
    
}
