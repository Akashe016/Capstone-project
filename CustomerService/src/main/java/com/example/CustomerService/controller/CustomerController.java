package com.example.CustomerService.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerService.entity.CustomerEntity;
import com.example.CustomerService.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService service;
	
	// customer details
	
	@GetMapping("/getCustomer")
	public String getCustomer() {
		
		return "Akash";
	}
	
		@GetMapping("/getaccount")
		public String getAccount() {
			
			return service.getDetails();
		}
	
			@PostMapping("/createcustomer")
			public CustomerEntity postCustomer(@RequestBody CustomerEntity entity) {
				
				return service.customerCreate(entity);
			}

			@PutMapping("/updatecustomer")
			public CustomerEntity putCustomer(@RequestBody CustomerEntity entity) {
			
				return service.customerUpdate(entity);
			}
			
			@GetMapping("/getcustomer")
			public Optional<CustomerEntity> getCustomer(@RequestParam int id) {
				
				return service.customerGet(id);
			}
			
			@DeleteMapping("/deletecustomer")
			public String deleteCustomer(@RequestParam int id) {
				
				return service.customerDelete(id);
				
			}

}
