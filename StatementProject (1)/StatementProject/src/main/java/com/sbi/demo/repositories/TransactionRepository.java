package com.sbi.demo.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbi.demo.entity.Transaction;
import com.sbi.demo.entity.UserInput;

@Repository
public interface TransactionRepository {
	
	List<Transaction> findAllTransactionsOfOneAccount(int accountNumber);
	
	public List<Transaction> findAllTransactionsOfOneAccountByFilter(UserInput userInput);
}
