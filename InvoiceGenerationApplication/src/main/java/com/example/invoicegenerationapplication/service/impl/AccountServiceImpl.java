package com.example.invoicegenerationapplication.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.invoicegenerationapplication.dto.AccountDTO;
import com.example.invoicegenerationapplication.entity.Account;
import com.example.invoicegenerationapplication.repository.AccountRepository;
import com.example.invoicegenerationapplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public String singUp(AccountDTO accountDTO) {
		
		Account account =  new Account();
		
		account.setUserName(accountDTO.getUserName());
		account.setEmail(accountDTO.getEmail());
		account.setPassword(accountDTO.getPassword());
				
		if(checkFindByUserNameAndEmail(account.getUserName(), account.getEmail())) {
			
			accountRepository.save(account);
	
			return "Your account create successfully" ;
		}
		
		else {
			return "Your account already created, Go back to login";
		}
	}
		
	@Override
	public Map<String, String> singIn(String userName, String password) {
			
			
		Map<String, String> response = new HashMap<>();    

		Optional<Account> user = accountRepository.findByUserNameAndPassword(userName, password);
			
		if(user.isPresent()) {
				
			Account users = user.get();
	        Long id = users.getId();
		            		            
	        response.put( "Login Successfully", String.valueOf(id));
			return response;
			
		}
		else {
				
			response.put(  "Login falied!", null);
				
			return response;
		}
	}
		
	public boolean checkFindByUserNameAndEmail(String userName, String email) {
			
		Optional<Account> users = accountRepository.findByUserNameAndEmail(userName, email);		
			
		if(users.isPresent()) {
		
			return false;
		}
		else {
	
			return true;						
		}
	}


	@Override
	public Optional<Account> getIdAccount(Long id) {
			
		return accountRepository.findById(id);
	}


	@Override
	public List<Account> getAllAccount() {
			
		return accountRepository.findAll();
	}
}
