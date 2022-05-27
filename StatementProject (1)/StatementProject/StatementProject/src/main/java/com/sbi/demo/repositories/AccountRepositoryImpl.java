package com.sbi.demo.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sbi.demo.entity.Account;
import com.sbi.demo.entity.Customer;
import com.sbi.demo.entity.Transaction;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<Account> findAllAccountsOfOneCustomer(int customerID) {
				
		TypedQuery<Account> query = entityManager.createQuery("from Account a where a.customerDetails=:cd",Account.class);
		Customer c = new Customer();
		c.setCustomerID(customerID);
		query.setParameter("cd", c);
		return query.getResultList();
		
	}
	
	

}
