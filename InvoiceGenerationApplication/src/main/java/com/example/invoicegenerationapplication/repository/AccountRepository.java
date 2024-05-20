package com.example.invoicegenerationapplication.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.invoicegenerationapplication.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	
	Optional<Account> findByUserNameAndEmail(String username, String email);
	
	Optional<Account> findByUserNameAndPassword(String username, String password);
	
	
}
