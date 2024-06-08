package com.example.bankingProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.bankingProject.entity.BankingEntity;
import com.example.bankingProject.service.BankingService;

@RestController
public class BankingController {
    
    @Autowired
    private BankingService bankingService;
    
    @PostMapping("/fundTransfer")
    public String fundTransfer(@RequestBody BankingEntity bankingEntity){
        return bankingService.fundTransfer(bankingEntity);
    }
    
   
}