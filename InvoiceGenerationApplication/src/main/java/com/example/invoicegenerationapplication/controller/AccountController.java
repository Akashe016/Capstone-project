package com.example.invoicegenerationapplication.controller;


import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.invoicegenerationapplication.entity.Account;
import com.example.invoicegenerationapplication.service.AccountService;
import com.example.invoicegenerationapplication.service.impl.AccountServiceImpl;


@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@PostMapping("/signUp")
	public ResponseEntity<Map<String, String>> accountCreate(@RequestBody Account account) {
		
		Map<String, String> response = new HashMap<>();
		response.put("message", accountService.singup(account));
		return ResponseEntity.ok(response);	
	}
	
	
	  @GetMapping("/signIn") 
	  public ResponseEntity<Map<String, String>> login(@RequestParam String username, String password) {
	 
		  Map<String, String> response = new HashMap<>();
			response.put("message",accountService.singIn(username,password));

		  return ResponseEntity.ok(response);
	  }
}
