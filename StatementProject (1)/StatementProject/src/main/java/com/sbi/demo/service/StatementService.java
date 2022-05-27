package com.sbi.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sbi.demo.entity.Account;
import com.sbi.demo.entity.Transaction;
import com.sbi.demo.entity.UserInput;

@Service
public interface StatementService {
	
	public List<Account> findAllAccountsOfOneCustomerService(int customerID);
	
	List<Transaction> findAllTransactionsOfOneAccountService(int accountNumber);
	
	public List<Transaction> findAllTransactionsOfOneAccountByFilter(UserInput userInput);
	public boolean authenticateUser(String username,String password);
}
