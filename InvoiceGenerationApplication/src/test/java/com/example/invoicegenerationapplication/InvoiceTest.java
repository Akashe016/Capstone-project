package com.example.invoicegenerationapplication;

import org.junit.jupiter.api.Test;
import com.example.invoicegenerationapplication.entity.Invoice;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceTest {

    @Test
    void testUser() {
        Invoice invoice = new Invoice();
        invoice.setId(1L);
        invoice.setClientName("Client Name");
        invoice.setAmount(500.0);
        invoice.setDate("2024-05-13");
        invoice.setDescription("Description");

        assertEquals(1L, invoice.getId());
        assertEquals("Client Name", invoice.getClientName());
        assertEquals(500.0, invoice.getAmount());
        assertEquals("2024-05-13", invoice.getDate());
        assertEquals("Description", invoice.getDescription());
    }
}

