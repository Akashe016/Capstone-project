package com.app.process;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("/process")
	public String method() {
		
		return "Akash";
	}
	
}
