package com.example.customerProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@GetMapping("/getCustomer")
	public String getCustomer() {
		
		return "Akash";
	}
}