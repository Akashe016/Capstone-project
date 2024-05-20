package com.example.invoicegenerationapplication.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.invoicegenerationapplication.dto.InvoiceDTO;
import com.example.invoicegenerationapplication.entity.Account;
import com.example.invoicegenerationapplication.entity.Invoice;
import com.example.invoicegenerationapplication.repository.AccountRepository;
import com.example.invoicegenerationapplication.repository.InvoiceRepository;
import com.example.invoicegenerationapplication.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Invoice postInvoice(InvoiceDTO invoiceDTO, Long accountId) {
		
         Optional<Account> accountOptional = accountRepository.findById(accountId);
		
		 Invoice invoice = new Invoice();
		
		 if (accountOptional.isPresent()) {
	            Account account = accountOptional.get();
	            invoice.setAccount(account);
	            invoice.setClientName(invoiceDTO.getClientName());
	    		invoice.setAmount(invoiceDTO.getAmount());
	    		invoice.setDate(invoiceDTO.getDate());
	    		invoice.setDescription(invoiceDTO.getDescription());
	            
	            return invoiceRepository.save(invoice);
	        } else {
	            throw new RuntimeException("Account not found");
	        }
	}
	
	@Override
	public Invoice updateInvoice(InvoiceDTO invoiceDTO, Long accountId) {
		
		 Optional<Account> accountOptional = accountRepository.findById(accountId);
		
		 Invoice invoice = new Invoice();
		
		 if (accountOptional.isPresent()) {
		
			Account account = accountOptional.get();
	        invoice.setAccount(account);
	        invoice.setId(invoiceDTO.getId());
			invoice.setClientName(invoiceDTO.getClientName());
			invoice.setAmount(invoiceDTO.getAmount());
			invoice.setDate(invoiceDTO.getDate());
			invoice.setDescription(invoiceDTO.getDescription());
			
			return invoiceRepository.save(invoice);
		 } 
		 else {
	            throw new RuntimeException("Account not found");
	     }
	}
	
	@Override
	public List<Invoice> getAllInvoice(Long accountId) {
	
		return invoiceRepository.findByAccountId(accountId);
	}
	
	@Override
	public Invoice getByIdInvoie(Long id) {
		
		return invoiceRepository.findById(id).orElse(null);
	}
	
	@Override
	public String deleteInvoice(Long id) {
		
		invoiceRepository.deleteById(id);
		return "Delete Successfully";
	}
}
