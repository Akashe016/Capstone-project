package com.example.invoicegenerationapplication.service;

import com.example.invoicegenerationapplication.entity.Account;

public interface AccountService {

	public String singup(Account account);
	public String singIn(String username, String password);
}
