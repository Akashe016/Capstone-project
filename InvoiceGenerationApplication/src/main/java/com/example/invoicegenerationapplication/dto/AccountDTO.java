package com.example.invoicegenerationapplication.dto;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class AccountDTO {

	
	private Long id;
	
	@NotBlank(message = "UserName is mandatory")
	@Column(name="username" ,unique = true)
	private String userName;
	 
	@NotBlank(message = "Email is mandatory")
	@Column(unique = true)
	private String email;
	 
	@NotBlank(message = "Password is mandatory")
	private String password;
	 
	@CreationTimestamp	
	private LocalDate date;
	
	private List<InvoiceDTO> invoice;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<InvoiceDTO> getInvoice() {
		return invoice;
	}
	public void setInvoice(List<InvoiceDTO> invoice) {
		this.invoice = invoice;
	}
}