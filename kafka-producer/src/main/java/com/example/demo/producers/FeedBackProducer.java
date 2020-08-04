package com.example.demo.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.example.demo.domains.FeedBack;

@Component
public class FeedBackProducer {

	 @Autowired
	 @Qualifier("feedBackTemplate")
	    private KafkaTemplate<String, FeedBack> kafkaTemplate;

	    
	    public void sendMessage(FeedBack message) {

	        ListenableFuture<SendResult<String, FeedBack>> future = 
	        		kafkaTemplate.send("feedback",message);

	        future.addCallback(new ListenableFutureCallback<SendResult<String,FeedBack>>() {

	            @Override
	            public void onSuccess(SendResult<String, FeedBack> result) {
	                System.out.println("Sent message=[" + message + "]"
	                		+ " with offset=[" + result.getRecordMetadata()
	                    .offset() + "]");
	            }

	            @Override
	            public void onFailure(Throwable ex) {
	                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
	            }
	        });
	    }

}
