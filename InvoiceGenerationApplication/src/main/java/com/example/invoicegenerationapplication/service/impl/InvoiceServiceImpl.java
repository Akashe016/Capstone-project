package com.example.invoicegenerationapplication.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.invoicegenerationapplication.entity.Invoice;
import com.example.invoicegenerationapplication.repository.InvoiceRepository;
import com.example.invoicegenerationapplication.service.InvoiceService;


@Service
public class InvoiceServiceImpl implements InvoiceService {

	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public Invoice postInvoice(Invoice invoice) {
		
		return invoiceRepository.save(invoice);
	}
	
	@Override
	public Invoice updateInvoice(Invoice invoice) {
		
		invoice.setId(invoice.getId());	
		return invoiceRepository.save(invoice) ;
	}
	
	@Override
	public List<Invoice> getAllInvoice() {
	
		return invoiceRepository.findAll();
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
