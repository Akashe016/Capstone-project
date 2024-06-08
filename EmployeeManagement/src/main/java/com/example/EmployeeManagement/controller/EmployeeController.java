package com.example.EmployeeManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.EmployeeManagement.DTO.EmployeeDTO;
import com.example.EmployeeManagement.service.impl.EmployeeServiceImpl;

import jakarta.websocket.server.PathParam;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping("/createemployee")
	public EmployeeDTO create(@RequestBody EmployeeDTO dto) {
		
		return employeeServiceImpl.createEmployee(dto);
	}
	
	@GetMapping("/getAll")
	public List<EmployeeDTO> getAll() {
		
		return employeeServiceImpl.getAllEmployee();
	}
	
	@GetMapping("/getid")
	public EmployeeDTO getId(@RequestParam int id) {
		
		return employeeServiceImpl.getByIdEmployee(id);
	}
	
	@DeleteMapping("/deleteid")
	public String delete(@RequestParam int id) {
		
		return employeeServiceImpl.deleteEmployee(id);
	}
}
