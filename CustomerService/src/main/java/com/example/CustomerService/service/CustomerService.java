package com.example.CustomerService.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CustomerService.entity.CustomerEntity;
import com.example.CustomerService.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getCustomerDetails() {
		
		System.out.println("Inside customer service");
		return "HDFC Customer";
	}
	
	public String getDetails() {
		
		String response = restTemplate.getForObject("http://localhost:8082/getRestMethod", String.class);
		
		return response;
	}
	
	
	public CustomerEntity customerCreate(CustomerEntity entity) {
		
		return customerRepository.save(entity);

	}
	
	public CustomerEntity customerUpdate(CustomerEntity entity) {
			
		entity.setId(entity.getId());
		entity.setName(entity.getName());
		entity.setMobile(entity.getMobile());
		entity.setCity(entity.getCity());
		
		
		return customerRepository.save(entity);
	}
	
	public Optional<CustomerEntity> customerGet(int id) {
		
		return customerRepository.findById(id);
	}
	
	public String customerDelete(int id) {
		
		customerRepository.deleteById(id);

		return "Delete successfully";
	}
}
