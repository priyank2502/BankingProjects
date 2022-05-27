package com.sbi.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="transaction_details")
public class Transaction {
	
	@Id
	@GeneratedValue
	@Column(name="transaction_id")
	private double transactionNumber;
	
	/*@Column(name="account_number")
	private double accountNumber;*/
	
	@Column(name="transaction_date")
	private Date dateOfTxn;
	
	@Column(name="transaction_type")
	private String txnType;
	
	@Column(name="transaction_amount")
	private double txnBalance;
	
	@Column(name="transaction_narration")
	private String narration;
	
	@ManyToOne
	@JoinColumn(name="account_number")
	private Account accountDetails;
	
	/*public double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}*/
	public Account getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(Account accountDetails) {
		this.accountDetails = accountDetails;
	}
		
	public double getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(double transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
	public Date getDateOfTxn() {
		return dateOfTxn;
	}
	public void setDateOfTxn(Date dateOfTxn) {
		this.dateOfTxn = dateOfTxn;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public double getTxnBalance() {
		return txnBalance;
	}
	public void setTxnBalance(double txnBalance) {
		this.txnBalance = txnBalance;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	
	
	

}
