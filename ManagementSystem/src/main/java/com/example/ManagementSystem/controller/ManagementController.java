package com.example.ManagementSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ManagementSystem.Entity.ManagementEntity;
import com.example.ManagementSystem.service.ManagementService;


@RestController
@RequestMapping("/cat")
public class ManagementController {
	
	
	@Autowired
	ManagementService managementService;
	
	
	@PostMapping
	public ManagementEntity CreateMethod(@RequestBody ManagementEntity entity) {
		
		return managementService.create(entity);
	}
	
	@PutMapping
	public ManagementEntity updateMethod(@RequestBody ManagementEntity entity) {
		
		return managementService.update(entity);
	}
	
	@GetMapping
	public List<ManagementEntity> getMethod() {
		
		return managementService.getAll();
	}
	
	@GetMapping("/{id}")
	public ManagementEntity getIdMethod(@PathVariable int id) {
		
		return managementService.getByIdMethod(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteMethod(@PathVariable int id) {
		
		return managementService.deleteIdMethod(id);
		
	}
}
