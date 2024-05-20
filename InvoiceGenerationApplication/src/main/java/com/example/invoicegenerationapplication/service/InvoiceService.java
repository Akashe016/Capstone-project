package com.example.invoicegenerationapplication.service;

import java.util.List;
import com.example.invoicegenerationapplication.dto.InvoiceDTO;
import com.example.invoicegenerationapplication.entity.Invoice;

public interface InvoiceService {
	
	public Invoice postInvoice(InvoiceDTO invoiceDTO, Long accountId);
	public Invoice updateInvoice(InvoiceDTO invoiceDTO,  Long accountId);
	public List<Invoice> getAllInvoice(Long accountId);
	public Invoice getByIdInvoie(Long id);
	public String deleteInvoice(Long id);

}
