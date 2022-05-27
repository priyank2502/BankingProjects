package com.sbi.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.demo.entity.Account;
import com.sbi.demo.entity.Customer;
import com.sbi.demo.entity.Transaction;
import com.sbi.demo.entity.UserInput;
import com.sbi.demo.repositories.AccountRepository;
import com.sbi.demo.repositories.CustomerRepository;
import com.sbi.demo.repositories.TransactionRepository;

@Service
public class StatementServiceImpl implements StatementService{

	@Autowired
	AccountRepository accountRepository;
	@Override
	public List<Account> findAllAccountsOfOneCustomerService(int customerID) {
		return accountRepository.findAllAccountsOfOneCustomer(customerID);
	}

	@Autowired
	TransactionRepository txnRepository;
	@Override
	public List<Transaction> findAllTransactionsOfOneAccountService(int accountNumber) {
		
		return txnRepository.findAllTransactionsOfOneAccount(accountNumber);
		
	}
	
	public List<Transaction> findAllTransactionsOfOneAccountByFilter(UserInput userInput){
		System.out.println("Service Impl......");
		return txnRepository.findAllTransactionsOfOneAccountByFilter(userInput);
	}
	@Autowired
	CustomerRepository custRepository;
	@Override
	public boolean authenticateUser(String username, String password) {
		boolean loginStatus=false;
		List<Customer> custList = custRepository.findAllCustomers();
		for(Customer c:custList) {
			if(c.getLoginID()==username && c.getPassword()==password) {
				loginStatus = true;
			}
			else 
				loginStatus = false;
		}
		return loginStatus;
	}

}
