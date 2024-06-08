package com.example.loan_service.controller;


import com.example.loan_service.entity.LoanEntity;
import com.example.loan_service.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public List<LoanEntity> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanEntity> getLoanById(@PathVariable Long id) {
        Optional<LoanEntity> loan = loanService.getLoanById(id);
        return loan.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<LoanEntity> createLoan(@RequestBody LoanEntity loan) {
        LoanEntity createdLoan = loanService.createLoan(loan);
        return new ResponseEntity<>(createdLoan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanEntity> updateLoan(@PathVariable Long id, @RequestBody LoanEntity loan) {
        LoanEntity updatedLoan = loanService.updateLoan(id, loan);
        return new ResponseEntity<>(updatedLoan, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return "Delete Successfully";
    }
}