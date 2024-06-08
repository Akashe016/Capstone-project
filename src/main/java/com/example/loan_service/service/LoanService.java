package com.example.loan_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan_service.entity.LoanEntity;
import com.example.loan_service.repository.LoanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<LoanEntity> getAllLoans() {
        return loanRepository.findAll();
    }

    public Optional<LoanEntity> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public LoanEntity createLoan(LoanEntity loan) {
        return loanRepository.save(loan);
    }

    public LoanEntity updateLoan(Long id, LoanEntity loan) {
        loan.setId(id);
        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
