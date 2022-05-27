package com.sbi.demo.entity;

import java.sql.Date;

public class UserInput {
	
	int accountNumber;
	Date fromDate;
	Date toDate;
	double amtFrom;
	double amtTo;
	String txnType;
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public double getAmtFrom() {
		return amtFrom;
	}
	public void setAmtFrom(int amtFrom) {
		this.amtFrom = amtFrom;
	}
	public double getAmtTo() {
		return amtTo;
	}
	public void setAmtTo(int amtTo) {
		this.amtTo = amtTo;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	
}
