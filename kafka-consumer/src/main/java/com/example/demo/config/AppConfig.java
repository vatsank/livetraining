package com.example.demo.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.demo.domains.FeedBack;

import java.util.*;
@Configuration
public class AppConfig {

    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "msgs");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    public ConsumerFactory<String, FeedBack> feedBackConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "feedback-group");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
        		          new JsonDeserializer<>(FeedBack.class));
    }

    
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> 
               msgKafkaListenerContainerFactory() {
    	
        ConcurrentKafkaListenerContainerFactory<String, String> factory = 
       		 new ConcurrentKafkaListenerContainerFactory<>();
       factory.setConsumerFactory(consumerFactory());

        return factory;
    }

   
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, FeedBack> 
               feedBackKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, FeedBack> factory = 
        		 new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(feedBackConsumerFactory());
        return factory;
    }
    
    
   
}
