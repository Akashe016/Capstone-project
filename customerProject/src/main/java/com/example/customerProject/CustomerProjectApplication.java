package com.example.customerProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerProjectApplication {
	
	@Autowired
	CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(CustomerProjectApplication.class, args);
		System.out.println("Hi this is first application");
	}

}
