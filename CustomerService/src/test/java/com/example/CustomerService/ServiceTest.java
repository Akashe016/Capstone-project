package com.example.CustomerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.CustomerService.entity.CustomerEntity;
import com.example.CustomerService.service.CustomerService;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private CustomerService customerService;

    @Mock
    private CustomerService mockedCustomerService;
    
    @Autowired
    private CustomerEntity customerEntity;

    @Test
    public void testGetCustomerDetails() {
        String expectedCustomerDetails = "HDFC Customer";
        String actualCustomerDetails = customerService.getCustomerDetails();
        assertEquals(expectedCustomerDetails, actualCustomerDetails);
    }

    @Test
    public void testGetCustomerDetailsWithMock() {
        Mockito.when(mockedCustomerService.getCustomerDetails()).thenReturn("Inside customer service");
        String actualCustomerDetails = mockedCustomerService.getCustomerDetails();
        assertEquals("Inside customer service", actualCustomerDetails);
    }
    
    
    @Test
    public void testPostCustomerDetails() {
        CustomerEntity expectedCustomerDetails = customerService.customerCreate(customerEntity) ;
        CustomerEntity actualCustomerDetails = customerService.customerCreate(customerEntity);
        assertEquals(expectedCustomerDetails, actualCustomerDetails);
    }
    
    @Test
    public void testPutCustomerDetails() {
        CustomerEntity expectedCustomerDetails = customerService.customerUpdate(customerEntity);
        CustomerEntity actualCustomerDetails = customerService.customerUpdate(customerEntity);
        assertEquals(expectedCustomerDetails, actualCustomerDetails);
    }
    
    @Test
    public void testDeleteCustomerDetails() {
        String expectedCustomerDetails = "Delete Successfully";
        String actualCustomerDetails = customerService.customerDelete(0);
        assertEquals(expectedCustomerDetails, actualCustomerDetails);
    }
    
}