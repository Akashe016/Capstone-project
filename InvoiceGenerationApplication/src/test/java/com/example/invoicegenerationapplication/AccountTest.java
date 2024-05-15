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
    void testAccount() {
        account.setUser_id(1);
        account.setUsername("username");
        account.setEmail("example@gmail.com");
        account.setPassword("password");
        LocalDate currentDate = LocalDate.now();
        account.setDate(currentDate);

        assertEquals(1, account.getUser_id());
        assertEquals("username", account.getUsername());
        assertEquals("example@gmail.com", account.getEmail());
        assertEquals("password", account.getPassword());
        assertEquals(currentDate, account.getDate());
    }

    @Test
    void testToString() {
        account.setUser_id(1);
        account.setUsername("username");
        account.setEmail("example@gmail.com");
        account.setPassword("password");
        LocalDate currentDate = LocalDate.now();
        account.setDate(currentDate);

        String expectedString = "user_id=1, username=username, email=example@gmail.com, password=password, date=" + currentDate;
        assertEquals(expectedString, account.toString());
    }
}