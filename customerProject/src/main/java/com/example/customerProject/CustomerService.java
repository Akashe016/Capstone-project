package com.example.customerProject;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	public String getCustomerDetails() {
		
		System.out.println("Inside customer service");
		return "HDFC Customer";
	}

	public Object print() {
		// TODO Auto-generated method stub
		return null;
	}
}
