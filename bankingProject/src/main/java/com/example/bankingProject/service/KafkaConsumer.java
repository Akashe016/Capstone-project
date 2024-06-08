package com.example.bankingProject.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    
    @KafkaListener(topics = "test", groupId = "group_id")
    public void consume(String message) {
      
    }
}