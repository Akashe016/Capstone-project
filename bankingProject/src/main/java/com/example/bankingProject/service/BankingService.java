package com.example.bankingProject.service;

import org.springframework.stereotype.Service;

import com.example.bankingProject.entity.BankingEntity;

@Service
public class BankingService {
    
   
	public String fundTransfer(BankingEntity bankingEntity) {
		
		
		return "Fund transfer successful";
	}
}