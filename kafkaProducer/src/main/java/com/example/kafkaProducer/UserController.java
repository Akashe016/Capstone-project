package com.example.kafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	

	@Autowired
	KafkaTemplate<String, String> kt;
	
	@GetMapping("/send")
	public String sendMessage(@RequestParam String msg) {
		kt.send("Transaction",msg);
		return "msg sent -> "+msg;
	}

}
