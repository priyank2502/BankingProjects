package com.sbi.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.demo.entity.Account;
import com.sbi.demo.entity.Transaction;
import com.sbi.demo.entity.UserInput;
import com.sbi.demo.service.StatementService;

@CrossOrigin
@RestController  //class has an application to host in web
@RequestMapping("/statement")
public class StatementController {
	
	@Autowired
	StatementService stmtService;
	
	
	
	@RequestMapping("/AccountList/{cid}")//http://localhost:8080/statement/AccountList/50001
	public List<Account> findAllAccountsOfOneCustomerController(@PathVariable("cid") int customerID) {
		return stmtService.findAllAccountsOfOneCustomerService(customerID);
	}
	
	@RequestMapping("/AccountStatement/{accNr}")//http://localhost:8080/statement/AccountStatement/100001
	public List<Transaction> findAllTransactionsOfOneAccountController(@PathVariable("accNr")  int accountNumber) {
		
		return stmtService.findAllTransactionsOfOneAccountService(accountNumber);
	}
	@PostMapping("/Filter")//http://localhost:8080/statement/Filter/
	public List<Transaction> findAllTransactionsOfOneAccountByFilterService(@RequestBody UserInput userInput){
		return stmtService.findAllTransactionsOfOneAccountByFilter(userInput);
		
	}
	
}
