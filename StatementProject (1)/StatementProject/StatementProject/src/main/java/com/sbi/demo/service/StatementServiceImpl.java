package com.sbi.demo.service;


 

import java.io.FileOutputStream;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
		return txnRepository.findAllTransactionsOfOneAccountByFilter(userInput);
	}
	
	public void generatePDF() {
		 Document document = new Document();

	        try {
	            PdfWriter.getInstance(document,
	                new FileOutputStream("HelloWorld-Table.pdf"));

	            document.open();

	            PdfPTable table = new PdfPTable(3); // 3 columns.

	            PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
	            PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
	            PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));

	            table.addCell(cell1);
	            table.addCell(cell2);
	            table.addCell(cell3);

	            document.add(table);

	            document.close();
	        } catch(Exception e){

	        }
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
