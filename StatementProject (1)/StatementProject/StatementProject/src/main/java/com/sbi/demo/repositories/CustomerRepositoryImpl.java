package com.sbi.demo.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbi.demo.entity.Account;
import com.sbi.demo.entity.Customer;
@Repository
public class CustomerRepositoryImpl  implements CustomerRepository{
	@Autowired	
	Customer custRepository;
		@PersistenceContext
		EntityManager entityManager;
		
		public List<Customer> findAllCustomers(){
			Query query = entityManager.createQuery("from Customer",Account.class);
			return query.getResultList();
		}
			
		
}
