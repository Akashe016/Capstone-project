package com.example.invoicegenerationapplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.invoicegenerationapplication.entity.Account;
import com.example.invoicegenerationapplication.repository.AccountRepository;

@SpringBootTest
public class AccountRepositoryTest {

    private AccountRepository accountRepository;
    
    @BeforeEach
    public void setUp() {
        accountRepository = mock(AccountRepository.class);
    }
    
    @Test
    public void testSaveAccount() {
    	
        Account account = new Account();
        account.setUsername("Akash");
        account.setEmail("example@gmail.com");
        account.setPassword("password");
        account.setDate(LocalDate.now());

        when(accountRepository.save(account)).thenAnswer(invocation -> {
             Account savedAccount = invocation.getArgument(0);
             savedAccount.setUser_id(1);
             return savedAccount;
        });

        Account savedAccount = accountRepository.save(account);

        assertThat(savedAccount).isNotNull();
        assertThat(savedAccount.getUser_id()).isGreaterThan(0);
    } 
    
    @Test
    public void testSuccessfulSignIn() {
    	 	
   		String username = "Akash";
   	    String password = "password";
   	    Account account = new Account();
   	    account.setUsername(username);
   	    account.setPassword(password);
        when(accountRepository.findByUsernameAndPassword(username, password)).thenReturn(Optional.of(account));

   	    Optional<Account> result = accountRepository.findByUsernameAndPassword(username, password);
   	    assertThat(result).isPresent();
   	    assertThat(result.get().getUsername()).isEqualTo(username);
   	    assertThat(result.get().getPassword()).isEqualTo(password); 
    }

    @Test
    public void testFailedSignInIncorrectPassword() {
        
   		String username = "Akash";
   		String password = "wrongPassword"; 
   		Account account = new Account();
   		account.setUsername(username);
   		account.setPassword("testPassword"); 
   		accountRepository.save(account); 

   		Optional<Account> result = accountRepository.findByUsernameAndPassword(username, password);
   		assertThat(result).isNotPresent();
    }

    @Test
    public void testFailedSignIn_NonexistentUser() {

    	String username = "nonexistentUser";
       	String password = "anyPassword";

       	Optional<Account> result = accountRepository.findByUsernameAndPassword(username, password);
       	assertThat(result).isNotPresent();
    }
    
    @Test
    public void testFindByUsernameAndEmail() {
        
        String username = "Akash";
        String email = "example@gmail.com";
        
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setUsername(username);
        account.setEmail(email);
        accounts.add(account);
        
        when(accountRepository.findByUsernameAndEmail(username, email)).thenReturn(accounts);
        
        List<Account> result = accountRepository.findByUsernameAndEmail(username, email);
        
        assertEquals(1, result.size());
        assertEquals(username, result.get(0).getUsername());
        assertEquals(email, result.get(0).getEmail());
    }
    
    @Test
    public void testFindByUsernameAndPassword() {
       
        String username = "Akash";
        String password = "password";
        
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        
        when(accountRepository.findByUsernameAndPassword(username, password)).thenReturn(Optional.of(account));
        
        Optional<Account> result = accountRepository.findByUsernameAndPassword(username, password);
        
        assertEquals(username, result.get().getUsername());
        assertEquals(password, result.get().getPassword());
    }
}