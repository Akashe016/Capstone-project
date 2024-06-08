package com.example.SpringBoot.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringBoot.entity.ReportEntity;
import com.example.SpringBoot.service.UserService;

@RestController
public class UserController{
	
	@Autowired
	UserService service;
	
	@GetMapping("/getCustomer")
	public String getCustomer() {
		
		return "Akash";
	}
	
	@GetMapping("/getRestMethod")
	public String method() {
		
		return "12345678";
	}
	

	
	@PostMapping("/createreport")
	public ReportEntity postReport(@RequestBody ReportEntity entity) {
		
		return service.reportCreate(entity);
	}

	@PutMapping("/updatereport")
	public ReportEntity putReport(@RequestBody ReportEntity entity) {
	
		return service.reportUpdate(entity);
	}
	
	@GetMapping("/getreport")
	public Optional<ReportEntity> getReport(@RequestParam int id) {
		
		return service.reportGet(id);
	}
	
	@DeleteMapping("/deletereport")
	public String deleteReport(@RequestParam int id) {
		
		return service.reportDelete(id);	
	}
}