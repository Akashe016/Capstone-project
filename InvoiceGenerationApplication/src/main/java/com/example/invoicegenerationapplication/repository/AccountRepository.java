package com.example.invoicegenerationapplication.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.invoicegenerationapplication.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
		List<Account> findByUsernameAndEmail(String username, String email);
	
		Optional<Account> findByUsernameAndPassword(String username, String password);

}
