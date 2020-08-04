package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.producers.MessageProducer;

@SpringBootApplication
public class KafkaProducerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(KafkaProducerApplication.class, args);
		
        
        MessageProducer producer = context.getBean(MessageProducer.class);
        producer.sendMessage(args[0]);

	}

}
