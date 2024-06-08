package com.example.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/payment")
	public String hello() {
		return "Payment Done";
	}
	
	 @GetMapping("/getRestMethod")
		public String method() {
			
			return "12345678";
		}
}