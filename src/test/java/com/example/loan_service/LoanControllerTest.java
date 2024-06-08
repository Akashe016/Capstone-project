package com.example.loan_service;


import com.example.loan_service.controller.LoanController;
import com.example.loan_service.entity.LoanEntity;
import com.example.loan_service.service.LoanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class LoanControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LoanService loanService;

    @InjectMocks
    private LoanController loanController;

    @SuppressWarnings("deprecation")
	@BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(loanController).build();
    }

   
    @Test
    void getAllLoans() throws Exception {

    	List<LoanEntity> loans = Arrays.asList(
            new LoanEntity(1L, "Akash", 5000.0),
            new LoanEntity(2L, "Siddarth", 10000.0)
        );

        when(loanService.getAllLoans()).thenReturn(loans);

        mockMvc.perform(get("/api/loans"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].customerName").value("Akash"))
                .andExpect(jsonPath("$[0].loanAmount").value(5000.0))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].customerName").value("Siddarth"))
                .andExpect(jsonPath("$[1].loanAmount").value(10000.0));
    }

	@Test
    void getLoanById() throws Exception {

		LoanEntity loan = new LoanEntity(1L, "Akash", 5000.0);
        when(loanService.getLoanById(1L)).thenReturn(Optional.of(loan));
        mockMvc.perform(get("/api/loans/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.customerName").value("Akash"))
                .andExpect(jsonPath("$.loanAmount").value(5000.0));
    }

    @Test
    void createLoan() throws Exception {

    	LoanEntity loan = new LoanEntity(1L, "Akash", 5000.0);
        when(loanService.createLoan(any(LoanEntity.class))).thenReturn(loan);
        mockMvc.perform(post("/api/loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(loan)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.customerName").value("Akash"))
                .andExpect(jsonPath("$.loanAmount").value(5000.0));
    }
    
    @Test
    void updateLoan() throws Exception {

    	LoanEntity loan = new LoanEntity();
        loan.setId(1L);
        loan.setCustomerName("Akash");
        loan.setLoanAmount(5000.0);
        when(loanService.updateLoan(eq(1L), any(LoanEntity.class))).thenReturn(loan);
        mockMvc.perform(put("/api/loans/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(loan)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.customerName").value("Akash"))
                .andExpect(jsonPath("$.loanAmount").value(5000.0));
    }

  
    @Test
    void deleteLoan() throws Exception {

    	doNothing().when(loanService).deleteLoan(1L);
        mockMvc.perform(delete("/api/loans/{id}", 1))
                .andExpect(status().isNoContent());
    }

    
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}