package com.example.oneToOneMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private String city;
	private String country;
	
	/*
	 * @OneToOne(mappedBy = "address")
	 * 
	 * @JoinColumn(name = "emp_id") private Employee employee;
	 * 
	 * 
	 * 
	 * public Employee getEmployee() { return employee; } public void
	 * setEmployee(Employee employee) { this.employee = employee; }
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
