package com.example.invoicegenerationapplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.invoicegenerationapplication.dto.InvoiceDTO;
import com.example.invoicegenerationapplication.entity.Invoice;
import com.example.invoicegenerationapplication.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	
	@PostMapping("/newInvoice")
	public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceDTO invoiceDTO, @RequestParam Long accountId) {
			
        Invoice createdInvoice = invoiceService.postInvoice(invoiceDTO, accountId);
		return ResponseEntity.ok(createdInvoice);
	}
	
	
	@PutMapping("/editInvoice")
	public ResponseEntity<Invoice> editInvoice(@RequestBody InvoiceDTO invoiceDTO,  @RequestParam Long accountId) {
		
		Invoice updateInvoice = invoiceService.updateInvoice(invoiceDTO, accountId);
		return ResponseEntity.ok(updateInvoice);
	}
	
	
	@GetMapping("/listOfInvoice")
	public ResponseEntity<List<Invoice>> getAllInvoice(@RequestParam Long accountId) {
		
		List<Invoice> getAll = invoiceService.getAllInvoice(accountId);
		return ResponseEntity.ok(getAll);
	}
	
	
	@GetMapping("/getIdInvoice")
	public ResponseEntity<Invoice> getIdInvoie(@RequestParam Long id) {
		
		Invoice getId = invoiceService.getByIdInvoie(id);
		return ResponseEntity.ok(getId);
	}
	
	
	@DeleteMapping("/deleteInvoice")
	public ResponseEntity<String> deleteInvoice(@RequestParam Long id) {
		
		String delete =  invoiceService.deleteInvoice(id);
		return ResponseEntity.ok(delete);
	}
}
