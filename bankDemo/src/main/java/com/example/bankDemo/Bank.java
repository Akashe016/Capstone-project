package com.example.bankDemo;

public class Bank {

	private int id;
	private String name;
	private long account_no;
	private double balance;
	private String city;	
	
	public Bank() {

	}
	
	public Bank(int id, String name, long account_no, double balance, String city) {
		this.id = id;
		this.name = name;
		this.account_no = account_no;
		this.balance = balance;
		this.city = city;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAccount_no() {
		return account_no;
	}
	public void setAccount_no(long account_no) {
		this.account_no = account_no;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", account_no=" + account_no + ", balance=" + balance + ", city="
				+ city + "]";
	}
	
	
	
}
