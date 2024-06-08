package com.example.bankDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

	@Autowired
	BankService bankService;
	
	@PostMapping()
	public String name(@RequestBody Bank bank) {
		
		return bankService.name(bank);
	}
}
