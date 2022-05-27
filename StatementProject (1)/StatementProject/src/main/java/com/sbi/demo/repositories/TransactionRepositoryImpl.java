package com.sbi.demo.repositories;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sbi.demo.entity.Account;
import com.sbi.demo.entity.Transaction;
import com.sbi.demo.entity.UserInput;
import com.sbi.demo.service.CreatePDFService;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<Transaction> findAllTransactionsOfOneAccount(int accountNumber) {
		List<Transaction> txnList = null;
		try {
			Query query = entityManager.createQuery("select * from transaction_details where account_number="+accountNumber,Transaction.class);
			txnList = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return txnList;
	}
	
	public List<Transaction> findAllTransactionsOfOneAccountByFilter(UserInput userInput) {
		List<Transaction> txnList = null;
		CreatePDFService cps;
		try {
			System.out.println("userInput.getTxnType(): "+userInput.getTxnType());
			if(userInput.getTxnType().equalsIgnoreCase("all")) {
				System.out.println("Inside all");
				Query query = entityManager.createNativeQuery("select * from transaction_details where account_number="+userInput.getAccountNumber()+
						  " and transaction_date between "+"to_date('"+userInput.getFromDate()+"','yyyy-MM-dd') and to_date('"+userInput.getToDate()+"','yyyy-MM-dd')"+
						  " and transaction_amount between "+userInput.getAmtFrom()+" and "+userInput.getAmtTo(),
						  Transaction.class);
				System.out.println("QUERY : "+query);
				txnList = query.getResultList();
				
			}
			else if(userInput.getTxnType().equalsIgnoreCase("dr")||userInput.getTxnType().equalsIgnoreCase("cr")){
				
				System.out.println("Inside dr/cr");
				Query query = entityManager.createNativeQuery("select * from transaction_details where account_number="+userInput.getAccountNumber()+
															  " and transaction_type="+"'"+userInput.getTxnType()+"'"+
															  " and transaction_date between "+"to_date('"+userInput.getFromDate()+"','yyyy-MM-dd') and to_date('"+userInput.getToDate()+"','yyyy-MM-dd')"+
															  " and transaction_amount between "+userInput.getAmtFrom()+" and "+userInput.getAmtTo(),
															  Transaction.class);
				System.out.println("QUERY : "+query);
				txnList = query.getResultList();
			}
			else if(userInput.getFilterCriteria().equalsIgnoreCase("byDate")) {
				System.out.println("By date");
				Query query = entityManager.createNativeQuery("select * from transaction_details where account_number="+userInput.getAccountNumber()+
															 // " and transaction_type="+"'"+userInput.getTxnType()+"'"+
															  " and transaction_date between "+"to_date('"+userInput.getFromDate()+"','yyyy-MM-dd') and to_date('"+userInput.getToDate()+"','yyyy-MM-dd')",
															  //" and transaction_amount between "+userInput.getAmtFrom()+" and "+userInput.getAmtTo(),
															  Transaction.class);
				System.out.println("QUERY : "+query);
				txnList = query.getResultList();
				
			}
			else if(userInput.getFilterCriteria().equalsIgnoreCase("last6Months")) {
				System.out.println("by last6Months");
				Calendar cal = Calendar.getInstance();  
				cal.add(Calendar.MONTH, -6); 
				
				java.sql.Date fromDate = new java.sql.Date(cal.getTime().getYear(),cal.getTime().getMonth(),cal.getTime().getDate());
				
				long millis=System.currentTimeMillis();  
		        java.sql.Date toDate=new java.sql.Date(millis); //Current Date
		        
				Query query = entityManager.createNativeQuery("select * from transaction_details where account_number="+userInput.getAccountNumber()+
															 // " and transaction_type="+"'"+userInput.getTxnType()+"'"+
															  " and transaction_date between "+"to_date('"+fromDate+"','yyyy-MM-dd') and to_date('"+toDate+"','yyyy-MM-dd')",
															  //" and transaction_amount between "+userInput.getAmtFrom()+" and "+userInput.getAmtTo(),
															  Transaction.class);
				System.out.println("QUERY : "+query);
				txnList = query.getResultList();
				
			}
			else if(userInput.getFilterCriteria().equalsIgnoreCase("financialStatement")) {
				System.out.println("by financial Statement");
				Calendar cal = Calendar.getInstance();  
				 
				
				java.sql.Date fromDate = new java.sql.Date(cal.getTime().getYear(),cal.getTime().getMonth(),cal.getTime().getDate());
				
				long millis=System.currentTimeMillis();  
		        java.sql.Date toDate=new java.sql.Date(millis); //Current Date
		        
				Query query = entityManager.createNativeQuery("select * from transaction_details where account_number="+userInput.getAccountNumber()+
															 // " and transaction_type="+"'"+userInput.getTxnType()+"'"+
															  " and transaction_date between "+"to_date('"+fromDate+"','yyyy-MM-dd') and to_date('"+toDate+"','yyyy-MM-dd')",
															  //" and transaction_amount between "+userInput.getAmtFrom()+" and "+userInput.getAmtTo(),
															  Transaction.class);
				System.out.println("QUERY : "+query);
				txnList = query.getResultList();
				
			}
		/*	if(txnList!=null)	{
				cps.createPdf(txnList);
			}*/
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return txnList;
	}

}
