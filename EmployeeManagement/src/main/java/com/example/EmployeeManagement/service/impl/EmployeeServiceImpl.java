package com.example.EmployeeManagement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EmployeeManagement.DTO.EmployeeDTO;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO dto) {
		
		return employeeRepository.save(dto);
	}
	
	@Override
	public List<EmployeeDTO> getAllEmployee() {
		
		return employeeRepository.findAll();
		
	}
	
	@Override
	public EmployeeDTO getByIdEmployee(int id) {
		
		return employeeRepository.findById(id).orElse(null);
	}
	
	@Override
	public String deleteEmployee(int id) {
		
		 employeeRepository.deleteById(id);
		 
		 return "Delete Successfully";
	}
}
