package com.example.invoicegenerationapplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.invoicegenerationapplication.entity.Invoice;
import com.example.invoicegenerationapplication.service.InvoiceService;
import com.example.invoicegenerationapplication.service.impl.InvoiceServiceImpl;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@PostMapping("/newInvoice")
	public Invoice createInvoice(@RequestBody Invoice invoice) {
			
		return invoiceService.postInvoice(invoice);
	}
	
	@PutMapping("/editInvoice")
	public Invoice editInvoice(@RequestBody Invoice invoice) {
		
		return invoiceService.updateInvoice(invoice);
	}
	
	@GetMapping("/listOfInvoice")
	public List<Invoice> getAllInvoice() {
	
		return invoiceService.getAllInvoice();
	}
	
	@GetMapping("/getIdInvoice")
	public Invoice getIdInvoie(@RequestParam Long id) {
		
		return invoiceService.getByIdInvoie(id);
	}
	
	@DeleteMapping("/deleteInvoice")
	public String deleteInvoice(@RequestParam Long id) {
		
		return invoiceService.deleteInvoice(id);
	}
}
