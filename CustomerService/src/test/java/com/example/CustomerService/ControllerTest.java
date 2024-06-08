package com.example.CustomerService;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.example.CustomerService.entity.CustomerEntity;
import com.example.CustomerService.service.CustomerService;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @Test
    public void testGetAccount() throws Exception {
        String expectedResult = "some response";
        when(service.getDetails()).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/getaccount")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResult));
    }

    @Test
    public void testPostCustomer() throws Exception {
        CustomerEntity customerEntity = new CustomerEntity();
        // Set properties of customerEntity

        when(service.customerCreate(customerEntity)).thenReturn(customerEntity);

        mockMvc.perform(MockMvcRequestBuilders.post("/createcustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"John\",\"mobile\":1234567890,\"city\":\"New York\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"));
    }

    @Test
    public void testPutCustomer() throws Exception {
        CustomerEntity customerEntity = new CustomerEntity();
        

        when(service.customerUpdate(customerEntity)).thenReturn(customerEntity);

        mockMvc.perform(MockMvcRequestBuilders.put("/updatecustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"John\",\"mobile\":1234567890,\"city\":\"New York\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"));
    }

    @Test
    public void testGetCustomer() throws Exception {
        CustomerEntity customerEntity = new CustomerEntity();
      

        when(service.customerGet(1)).thenReturn(Optional.of(customerEntity));

        mockMvc.perform(MockMvcRequestBuilders.get("/getcustomer?id=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(customerEntity.getName()));
    }

    @Test
    public void testDeleteCustomer() throws Exception {
        when(service.customerDelete(1)).thenReturn("Delete successfully");

        mockMvc.perform(MockMvcRequestBuilders.delete("/deletecustomer?id=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Delete successfully"));

        verify(service).customerDelete(1);
    }
}