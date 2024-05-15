package com.example.invoicegenerationapplication;

import com.example.invoicegenerationapplication.entity.Invoice;
import com.example.invoicegenerationapplication.repository.InvoiceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;
	

    @Test
    public void testSaveInvoice() {
    	
    	Invoice invoice = new Invoice();
        invoice.setClientName("Akash");
        invoice.setAmount(100.0);
        invoice.setDate("2023-05-14");
        invoice.setDescription("description");
        invoiceRepository.save(invoice);
        Assertions.assertThat(invoice.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindById() {
		
        Invoice invoice = invoiceRepository.findById(2L).get();
        Assertions.assertThat(invoice.getId()).isEqualTo(2L);
    }

    @Test
    public void testFindAll() {

        List<Invoice> invoices = invoiceRepository.findAll();
        Assertions.assertThat(invoices.size()).isGreaterThan(0);
    }

    @Test
    public void testUpdateInvoice() {
    	Invoice invoice = invoiceRepository.findById(2L).get();

    	invoice.setClientName("E Akash");
        Invoice updatedInvoice = invoiceRepository.save(invoice);
        Assertions.assertThat(updatedInvoice.getClientName()).isEqualTo("E Akash");
    }

    @Test
    public void testDeleteById() {
    	
    	Invoice invoice = invoiceRepository.findById(2L).get();
    	invoiceRepository.delete(invoice);
        Invoice invoice1 = null;

        Optional<Invoice> optionalInvoice = invoiceRepository.findByClientName("E Akash");

        if(optionalInvoice.isPresent()){
        	invoice1 = optionalInvoice.get();
        }

        Assertions.assertThat(invoice1).isNull();    
    }
}
