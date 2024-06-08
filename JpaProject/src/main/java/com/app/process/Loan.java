package com.app.process;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Loan {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String loanname;
	private String loanDesc;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoanname() {
		return loanname;
	}
	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}
	public String getLoanDesc() {
		return loanDesc;
	}
	public void setLoanDesc(String loanDesc) {
		this.loanDesc = loanDesc;
	}
}

