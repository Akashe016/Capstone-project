package com.example.invoicegenerationapplication.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.invoicegenerationapplication.dto.AccountDTO;
import com.example.invoicegenerationapplication.entity.Account;

public interface AccountService {

	public String singUp(AccountDTO accountDto);
	public Map<String, String> singIn(String userName, String password);
	public Optional<Account> getIdAccount(Long id);
	public List<Account>  getAllAccount();
}
