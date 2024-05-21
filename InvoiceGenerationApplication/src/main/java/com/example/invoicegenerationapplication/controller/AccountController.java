package com.example.invoicegenerationapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.invoicegenerationapplication.dto.AccountDTO;
import com.example.invoicegenerationapplication.entity.Account;
import com.example.invoicegenerationapplication.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@PostMapping("/signUp")
	public ResponseEntity<Map<String, String>> accountCreate(@RequestBody AccountDTO accountDTO) {
		
		Map<String, String> response = new HashMap<>();
	        
	    try {
	           
	    	response.put("message", accountService.singUp(accountDTO));
	    	
	        return ResponseEntity.ok(response);
	    } 
	    catch (Exception e) {

	    	response.put("message","An error occurred while creating the account.");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}
	
	
	@GetMapping("/signIn")
	public ResponseEntity<?>login(@RequestParam String username, String password) {
			 	
		try {
	 	   
	    	Map<String, String> response = accountService.singIn(username, password);
	        return ResponseEntity.ok(response);
	    }
	 	catch (Exception e) {
	            
	 		String response = "An error occurred while Login.";
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}
	
	
	@GetMapping("/getIdByAccount") 
	public ResponseEntity<Optional<Account>>getIdByAccount(@RequestParam Long id) {
	  
		Optional<Account> getAll = accountService.getIdAccount(id);
		return ResponseEntity.ok(getAll); 
	}
	  
	@GetMapping("/getAllAccount") 
	public ResponseEntity<List<Account>>getAllAccount() {
	  
		List<Account> getAll = accountService.getAllAccount();
	  
		return ResponseEntity.ok(getAll); 
	}
}
