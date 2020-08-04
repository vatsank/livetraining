package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.consumers.FeedBackListener;
import com.example.demo.consumers.MyMessageListener;

@SpringBootApplication
public class KafkaConsumerApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context=	SpringApplication.run(KafkaConsumerApplication.class, args);
		
		
//	MyMessageListener listener = context.getBean(MyMessageListener.class);
//	
//    try {
//		listener.latch.await(10, TimeUnit.SECONDS);
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	}
//
//
//	}

FeedBackListener listener = context.getBean(FeedBackListener.class);
	
    try {
		listener.latch.await(10, TimeUnit.SECONDS);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}


	}

}
