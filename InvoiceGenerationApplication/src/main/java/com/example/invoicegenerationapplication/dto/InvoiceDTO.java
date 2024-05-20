package com.example.invoicegenerationapplication.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class InvoiceDTO {
	
	private Long id;
	 
	@NotBlank(message = "clientName is mandatory")
	private String clientName;
	
	@Min(value = 3000, message = "Amount should be greater than 3000")
	private double amount;
	 
	@NotBlank(message = "Date is mandatory")
	private String date ;
	 
	@NotBlank(message = "Description is mandatory")
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
}