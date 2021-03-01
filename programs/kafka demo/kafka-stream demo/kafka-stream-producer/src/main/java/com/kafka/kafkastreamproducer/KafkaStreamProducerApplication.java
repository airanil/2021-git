package com.kafka.kafkastreamproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableBinding(Source.class)
public class KafkaStreamProducerApplication {
	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamProducerApplication.class, args);
	}
}
