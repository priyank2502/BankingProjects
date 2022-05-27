package com.sbi.demo;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.DateConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.context.support.UiApplicationContextUtils;

import com.sbi.demo.entity.Account;
import com.sbi.demo.entity.Transaction;
import com.sbi.demo.entity.UserInput;
import com.sbi.demo.repositories.AccountRepository;
import com.sbi.demo.repositories.TransactionRepository;
import com.sbi.demo.repositories.TransactionRepositoryImpl;
import com.sbi.demo.service.CreatePDFService;
import com.sbi.demo.controller.StatementController;
@SpringBootTest
class StatementProjectApplicationTests {
	
	//AccountRepository accountRepository;
	@Autowired
	//AccountService accountService;
	StatementController controller;
	
	@Autowired
	TransactionRepository transRepo;
	
	@Test
	void findAllTransactionsOfOneAccountByFilterTest() {
		UserInput ui = new UserInput();
			
			ui.setAccountNumber(100001);
			String strDate1 = "2022-12-1";
			Date date1 = Date.valueOf(strDate1); 
			ui.setFromDate(date1);
			
			String strDate2 = "2022-12-10";
			Date date2 = Date.valueOf(strDate2);
			ui.setToDate(date2);
			
			ui.setAmtFrom(10000);
			ui.setAmtTo(20000);
			ui.setTxnType("dr");
			
			
			
		List<Transaction> txnList = transRepo.findAllTransactionsOfOneAccountByFilter(ui);
		for (Transaction transaction : txnList) {
			System.out.println("ACNO     : "+transaction.getAccountDetails().getAccountNumber());
			System.out.println("TXN TYPE : "+transaction.getTxnType());
			System.out.println("TXN AMT  : "+transaction.getTxnBalance());
			System.out.println("TXN DATE : "+transaction.getDateOfTxn());
			System.out.println("--------------------------------------");
		}
		
		
	}
	
	@Test
	void findAllAccountsTest() {
		//List<Account> accountList = accountRepository.findAllAccountsOfOneCustomer(50001);
		//List<Account> accountList = accountService.findAllAccountsOfOneCustomerService(50001);
		List<Account> accountList = controller.findAllAccountsOfOneCustomerController(50001);
		for(Account accList : accountList) {
			System.out.println("Account Number: "+accList.getAccountNumber());
			System.out.println("Account Type: "+accList.getAccountType());
			System.out.println("Account branch; " + accList.getBranchName());
		}
		
	}
	
	/*@Test
	void findAllAccountsServiceTest{
		List<Account> accountList = accountService.findAllAccountsOfOneCustomerService(50001);
		
		for(Account accList : accountList) {
			System.out.println("Account Number: "+accList.getAccountNumber());
			System.out.println("Account Type: "+accList.getAccountType());
			System.out.println("Account branch: " + accList.getBranchName());
		}
	}*/
	@Test
	public void testDate() {
		Calendar cal = Calendar.getInstance();  //Get current date/month i.e 27 Feb, 2012
		//cal.add(Calendar.YEAR, 1); 
		
		//java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getYear(),cal.getTime().getMonth(),cal.getTime().getDate());
		System.out.println("cURRENT yEAR: "+cal.getTime().getYear()  +" "+cal.getTime().getMonth()+" "+cal.getTime().getDate());
	}
	
	@Autowired
	CreatePDFService createPDFService;
	
	/*@Test
	public void createPDFTest() {
		try {
			createPDFService.createPdf();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

}
