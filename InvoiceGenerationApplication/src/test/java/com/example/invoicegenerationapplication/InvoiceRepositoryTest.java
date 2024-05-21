package com.example.invoicegenerationapplication;

import com.example.invoicegenerationapplication.entity.Invoice;
import com.example.invoicegenerationapplication.repository.InvoiceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    private Invoice invoice;

    @BeforeEach
    public void data() {
        invoice = new Invoice();
        invoice.setClientName("Akash");
        invoice.setAmount(3000.0);
        invoice.setDate("2023-05-14");
        invoice.setDescription("description");
    }

    @Test
    public void testSaveInvoice() {
        Invoice savedInvoice = invoiceRepository.save(invoice);
        Assertions.assertThat(savedInvoice.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindById() {
        Invoice savedInvoice = invoiceRepository.save(invoice);
        Optional<Invoice> foundInvoice = invoiceRepository.findById(savedInvoice.getId());
        Assertions.assertThat(foundInvoice).isPresent();
        Assertions.assertThat(foundInvoice.get().getId()).isEqualTo(savedInvoice.getId());
    }

    @Test
    public void testFindAll() {
        invoiceRepository.save(invoice);
        List<Invoice> invoices = invoiceRepository.findAll();
        Assertions.assertThat(invoices.size()).isGreaterThan(0);
    }

    @Test
    public void testUpdateInvoice() {
        Invoice savedInvoice = invoiceRepository.save(invoice);

        savedInvoice.setClientName("E Akash");
        Invoice updatedInvoice = invoiceRepository.save(savedInvoice);
        Assertions.assertThat(updatedInvoice.getClientName()).isEqualTo("E Akash");
    }

    @Test
    public void testDeleteById() {
        Invoice savedInvoice = invoiceRepository.save(invoice);

        invoiceRepository.deleteById(savedInvoice.getId());

        Optional<Invoice> deletedInvoice = invoiceRepository.findById(savedInvoice.getId());
        Assertions.assertThat(deletedInvoice).isNotPresent();
    }

    @Test
    public void testEmpty() {
        Long nonExistingInvoiceId = 999L;
        Optional<Invoice> foundInvoice = invoiceRepository.findById(nonExistingInvoiceId);
        Assertions.assertThat(foundInvoice).isNotPresent();
    }
}
