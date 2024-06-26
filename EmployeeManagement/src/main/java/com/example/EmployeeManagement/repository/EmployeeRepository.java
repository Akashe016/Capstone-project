package com.example.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagement.DTO.EmployeeDTO;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Integer> {

}
