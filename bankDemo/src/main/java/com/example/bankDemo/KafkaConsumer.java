package com.example.bankDemo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "test", groupId = "id")
	public void name(String msg) {
		
	}
}
