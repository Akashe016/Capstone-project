package com.example.invoicegenerationapplication.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.invoicegenerationapplication.entity.Account;
import com.example.invoicegenerationapplication.repository.AccountRepository;
import com.example.invoicegenerationapplication.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public String singup(Account account) {
		
				
		if(checkFindByUserNameAndEmail(account.getUsername(), account.getEmail())) {
			
			accountRepository.save(account);
	
			return "your account create successfully" ;
		}
		
		else {
			return "your account already created, Go back to login";
		}
	}
		
		
		@Override
		public String singIn(String username, String password) {
			
			
			if(checkfindOnlyNameAndPassword(username, password)) {
			
				return "Login Successfully";		
			}
			else {
				
				return "login falied!";
			}
		}
		
		private boolean checkfindOnlyNameAndPassword(String username, String password) {
			
			Optional<Account> user = accountRepository.findByUsernameAndPassword(username, password);
			
			return user.isPresent();
					
		}
		
		public boolean checkFindByUserNameAndEmail(String username, String email) {
	
			
			List<Account> user = accountRepository.findByUsernameAndEmail(username,email);

			if(user.isEmpty()) {

				return true;
			}
			else {

				Object s=user.get(0);
				String s1 = String.valueOf(s);	
				String split[] = s1.split(",");
				
				String c[] = new String[split.length];
								
				for(int i=0;i<split.length;i++) {
				
					String a = split[i];	
					String split1[] = a.split("=");
					c[i]= split1[1];
				}
				if(c[1].equals(username) && c[2].equals(email)) {
					
					return false;
				}
				else {
					
					return true;
				}
			}
		}
}
