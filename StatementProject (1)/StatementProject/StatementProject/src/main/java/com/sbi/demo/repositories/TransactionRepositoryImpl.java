package com.sbi.demo.repositories;

import java.sql.Date;
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
		try {
			/*Query query = entityManager.createQuery("select * from transaction_details where account_number="+userInput.getAccountNumber()+
														  " and transaction_type="+userInput.getTxnType()+
														  " and transaction_date between "+userInput.getFromDate()+" and "+userInput.getToDate()+
														  " and transaction_amount between "+userInput.getAmtFrom()+" and "+userInput.getAmtTo(),
														  Transaction.class);*/
			
			TypedQuery<Transaction> query = entityManager.createQuery("from Transaction t where "
					+ " t.accountDetails=:ad and t.txnType=:tt and  "
					+ " t.dateOfTxn >= :fd and t.dateOfTxn <= :td and  "
					+ " t.txnBalance between :amtFrm and :amtTo",Transaction.class);
			Account acType = new Account();
			acType.setAccountNumber(userInput.getAccountNumber());
			
			query.setParameter("ad", acType);
			query.setParameter("tt", userInput.getTxnType());
			query.setParameter("fd", userInput.getFromDate());
			query.setParameter("td", userInput.getToDate());
			query.setParameter("amtFrm", userInput.getAmtFrom());
			query.setParameter("amtTo", userInput.getAmtTo());
			System.out.println(">>from date "+userInput.getFromDate());
			System.out.println(">>To date "+userInput.getToDate());
			
			Set mySet = query.getParameters();
			for (Object object : mySet) {
				System.out.println(">>>object : "+object);
			}
			
			txnList = query.getResultList();
			return txnList;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return txnList;
	}

}
