package com.example.EmployeeManagement.service;

import java.util.List;

import com.example.EmployeeManagement.DTO.EmployeeDTO;

public interface EmployeeService {

	
	public EmployeeDTO createEmployee(EmployeeDTO dto);
	public List<EmployeeDTO> getAllEmployee();
	public EmployeeDTO getByIdEmployee(int id);
	public String deleteEmployee(int id);

}
