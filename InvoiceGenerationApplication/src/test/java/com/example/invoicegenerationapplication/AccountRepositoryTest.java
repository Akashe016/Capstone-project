package com.example.invoicegenerationapplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.invoicegenerationapplication.entity.Account;
import com.example.invoicegenerationapplication.repository.AccountRepository;

@SpringBootTest
public class AccountRepositoryTest {

    @Mock
    private AccountRepository accountRepository;
        
    @BeforeEach
    public void setUp() {
        accountRepository = mock(AccountRepository.class);
        
    }
    
    @Test
    public void testSaveAccount() {
      
		
		 Account account = new Account(); 
		 account.setUserName("Akash");
		 account.setEmail("example@gmail.com"); 
		 account.setPassword("password");
		 account.setDate(LocalDate.now());
		  
		 when(accountRepository.save(account)).thenAnswer(invocation -> { 
			
			 Account savedAccount = invocation.getArgument(0); 
			 savedAccount.setId(1L); 
			 return savedAccount;
		  
		 }
		 );
		  
		 Account savedAccount = accountRepository.save(account);
		  
		 assertThat(savedAccount).isNotNull();
		 assertThat(savedAccount.getId()).isGreaterThan(0);
		 
    } 
    
    @Test
    public void testSuccessfulSignIn() {
    	 	
   		String userName = "Akash";
   	    String password = "password";
   	    Account account = new Account();
   	    account.setUserName(userName);
   	    account.setPassword(password);
        when(accountRepository.findByUserNameAndPassword(userName, password)).thenReturn(Optional.of(account));

   	    Optional<Account> result = accountRepository.findByUserNameAndPassword(userName, password);
   	    assertThat(result).isPresent();
   	    assertThat(result.get().getUserName()).isEqualTo(userName);
   	    assertThat(result.get().getPassword()).isEqualTo(password); 
    }

    @Test
    public void testFailedSignIn_IncorrectPassword() {
        
   		String userName = "Akash";
   		String password = "wrongPassword"; 
   		Account account = new Account();
   		account.setUserName(userName);
   		account.setPassword("testPassword"); 
   		accountRepository.save(account); 

   		Optional<Account> result = accountRepository.findByUserNameAndPassword(userName, password);
   		assertThat(result).isNotPresent();
    }

    @Test
    public void testFailedSignIn_NonExitUser() {

    	String userName = "sam";
       	String password = "samPassword";

       	Optional<Account> result = accountRepository.findByUserNameAndPassword(userName, password);
       	assertThat(result).isNotPresent();
    }
    
    @Test
    public void testFindByUsernameAndEmail() {
        
    	String userName = "Akash";
        String email = "example@gmail.com";

        Account account = new Account();
        account.setUserName(userName);
        account.setEmail(email);

        when(accountRepository.findByUserNameAndEmail(userName, email)).thenReturn(Optional.of(account));

        Optional<Account> result = accountRepository.findByUserNameAndEmail(userName, email);

        assertTrue(result.isPresent());
        assertEquals(userName, result.get().getUserName());
        assertEquals(email, result.get().getEmail());
    }
    
   
    @Test
    public void testFindByUsernameAndPassword() {
       
        String userName = "Akash";
        String password = "password";
        
        Account account = new Account();
        account.setUserName(userName);
        account.setPassword(password);
        
        when(accountRepository.findByUserNameAndPassword(userName, password)).thenReturn(Optional.of(account));
        
        Optional<Account> result = accountRepository.findByUserNameAndPassword(userName, password);
        
        assertTrue(result.isPresent());
        assertEquals(userName, result.get().getUserName());
        assertEquals(password, result.get().getPassword());
    }
    
    @Test
    public void testFindById() {
    	
    	 Long accountId = 1L;
         Account account = new Account();
         account.setId(accountId);
         when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));

         Optional<Account> result = accountRepository.findById(accountId);

         assertTrue(result.isPresent());
         assertEquals(accountId, result.get().getId());
    }
    
    @Test
    public void testFindAll() {
    	
    	 Account account = new Account();
         account.setUserName("E Akash");
         account.setEmail("example06@gmail.com");
         account.setPassword("password");
         account.setDate(LocalDate.now());
         when(accountRepository.findAll()).thenReturn(List.of(account));

         List<Account> accounts = accountRepository.findAll();

         assertTrue(accounts.size() > 0);
    }
}