package com.example.oneToOneMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
