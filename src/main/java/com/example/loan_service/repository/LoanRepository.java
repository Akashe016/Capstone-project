package com.example.loan_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loan_service.entity.LoanEntity;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Long> {
}