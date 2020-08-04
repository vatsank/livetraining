package com.example.demo.consumers;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.domains.FeedBack;

@Component
public class FeedBackListener {

	 public CountDownLatch latch = new CountDownLatch(3);


	    @KafkaListener(topics = "feedback", groupId = "feedback-group", 
	    		containerFactory = "feedBackKafkaListenerContainerFactory")
	    public void listenGroupFeedBack(FeedBack message) {
	        System.out.println("Received Messasge in group 'feedback': " + message);
	        latch.countDown();
	    }

}
