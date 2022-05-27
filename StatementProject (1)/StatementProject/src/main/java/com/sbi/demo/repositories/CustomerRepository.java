package com.sbi.demo.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbi.demo.entity.Customer;

@Repository
public interface CustomerRepository {
	
	public List<Customer> findAllCustomers();
	

}
