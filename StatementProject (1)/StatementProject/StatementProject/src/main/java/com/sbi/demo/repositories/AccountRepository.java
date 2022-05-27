package com.sbi.demo.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbi.demo.entity.Account;

@Repository
public interface AccountRepository {
	
	public List<Account> findAllAccountsOfOneCustomer(int customerID);

}
