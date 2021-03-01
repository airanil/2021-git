package com.kafka.kafkaproducer.controller;

import com.kafka.kafkaproducer.model.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka/producer")
public class ProducerController {

    public static String TOPICSTRING="mytopic-string";
    public static String TOPICJSON="mytopic-json";

    @Autowired
    @Qualifier("kafkaJson")
    private KafkaTemplate<String,Flight> kafkaTemplate;

    @Autowired
    @Qualifier("kafkaString")
    private KafkaTemplate<String,String> kafkaTemplateString;

    @GetMapping("/string/{message}")
    public String ProduceMsgString(@PathVariable("message") final String message){

        kafkaTemplateString.send(TOPICSTRING,message);
        return "produced message " + message;
    }

    @GetMapping("/json/{message}")
    public String ProduceMsgJson(@PathVariable("message") final String message){

        Flight flt=new Flight("1","SQ","org","dst",message);
        kafkaTemplate.send(TOPICJSON,flt );
        return "produced message " + flt.toString();
    }

    
}
