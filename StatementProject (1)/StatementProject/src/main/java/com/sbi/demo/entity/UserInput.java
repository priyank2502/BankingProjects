package com.sbi.demo.entity;

import java.sql.Date;

public class UserInput {
	
	int accountNumber;
	Date fromDate;
	Date toDate;
	double amtFrom;
	double amtTo;
	String txnType;
	String filterCriteria;
	String filterCriteria1;
	
	public String getFilterCriteria1() {
		return filterCriteria1;
	}
	public void setFilterCriteria1(String filterCriteria1) {
		this.filterCriteria1 = filterCriteria1;
	}
	public String getFilterCriteria() {
		return filterCriteria;
	}
	public void setFilterCriteria(String filterCriteria) {
		this.filterCriteria = filterCriteria;
	}
	
	public double getAmtFrom() {
		return amtFrom;
	}
	public void setAmtFrom(double amtFrom) {
		this.amtFrom = amtFrom;
	}
	public double getAmtTo() {
		return amtTo;
	}
	public void setAmtTo(double amtTo) {
		this.amtTo = amtTo;
	}
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
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	
}
