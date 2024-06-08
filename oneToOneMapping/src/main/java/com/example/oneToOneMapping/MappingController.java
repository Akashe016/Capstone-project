package com.example.oneToOneMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {
    @Autowired
    private MappingService service;

    @PostMapping("/onetoone")
    public Employee createUser(@RequestBody Employee user) {
        return service.saveUser(user);
    }

    @GetMapping("/{id}")
    public Employee getUser(@PathVariable int id) {
        return service.getUserById(id);
    }
    
    @GetMapping("/number")
    public String method() {
    	
    	return "1234567890";
    }
}
