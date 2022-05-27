package com.sbi.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="account_details")
public class Account {
	
	@Id
	@GeneratedValue
	@Column(name="account_number")
	private int accountNumber;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="account_branch")
	private String branchName;
	
	@Column(name="curr_account_balance ")
	private double accountBalance;
	
	@Column(name="rate_of_interest ") 
	private String rateOfInterest;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customerDetails;
	
	public Customer getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}

	public String getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(String rateofInterest) {
		this.rateOfInterest = rateofInterest;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
}
