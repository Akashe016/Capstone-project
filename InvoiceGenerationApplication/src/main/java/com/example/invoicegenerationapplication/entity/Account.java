package com.example.invoicegenerationapplication.entity;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "UserName is mandatory")
	@Column(name="username",unique = true)
	private String userName;
	 
	@NotBlank(message = "Email is mandatory")
	@Column(unique = true)
	private String email;
	 
	@NotBlank(message = "Password is mandatory")
	private String password;
	 
	@CreationTimestamp	
	private LocalDate date;
	
    @JsonIgnore
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Invoice> invoice;
	
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
	public List<Invoice> getInvoice() {
		return invoice;
	}
	public void setInvoice(List<Invoice> invoice) {
		this.invoice = invoice;
	}
	
	/*
	 * @Override public String toString() { return "id=" + id +", username=" +
	 * userName + ", email=" + email + ", password=" + password +", date=" + date; }
	 */
}