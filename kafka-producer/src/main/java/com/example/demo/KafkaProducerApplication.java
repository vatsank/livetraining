package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.domains.FeedBack;
import com.example.demo.producers.FeedBackProducer;
import com.example.demo.producers.MessageProducer;

@SpringBootApplication
public class KafkaProducerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(KafkaProducerApplication.class, args);
		
        
        MessageProducer producer = context.getBean(MessageProducer.class);
        producer.sendMessage(args[0]);


//		FeedBackProducer producer = context.getBean(FeedBackProducer.class);
//		
//		FeedBack bean = context.getBean(FeedBack.class);
//		 producer.sendMessage(bean);
		
	}

	@Bean
	public FeedBack bean() {
		
		return new FeedBack(234, "annon", 3.9);
	}
}
