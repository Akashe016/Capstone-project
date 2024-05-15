package com.example.invoicegenerationapplication.service;

import java.util.List;
import com.example.invoicegenerationapplication.entity.Invoice;


public interface InvoiceService {
	
	public Invoice postInvoice(Invoice invoice);
	public Invoice updateInvoice(Invoice invoice);
	public List<Invoice> getAllInvoice();
	public Invoice getByIdInvoie(Long id);
	public String deleteInvoice(Long id);

}
