package com.example.invoicegenerationapplication;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.invoicegenerationapplication.entity.Account;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AccountTest {

    @InjectMocks
    private Account account;

    @Test
    void testAccountGetterAndSetter() {
        account.setId(1L);
        account.setUserName("username");
        account.setEmail("example@gmail.com");
        account.setPassword("password");
        LocalDate currentDate = LocalDate.now();
        account.setDate(currentDate);

        assertEquals(1, account.getId());
        assertEquals("username", account.getUserName());
        assertEquals("example@gmail.com", account.getEmail());
        assertEquals("password", account.getPassword());
        assertEquals(currentDate, account.getDate());
    }
}