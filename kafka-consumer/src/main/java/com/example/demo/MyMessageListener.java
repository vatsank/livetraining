package com.example.demo;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener {

    CountDownLatch latch = new CountDownLatch(3);


    @KafkaListener(topics = "greet", groupId = "msgs", containerFactory = "msgKafkaListenerContainerFactory")
    public void listenGroupFoo(String message) {
        System.out.println("Received Messasge in group 'msgs': " + message);
        latch.countDown();
    }

}
