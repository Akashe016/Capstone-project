package com.example.oneToOneMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingService {
    
	@Autowired
    private EmpRepository userRepository;

    public Employee saveUser(Employee user) {
        return userRepository.save(user);
    }

    public Employee getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
