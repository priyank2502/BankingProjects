package com.sbi.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbi.demo.entity.Transaction;
import com.sbi.demo.entity.UserInput;

@Service
public interface CreatePDFService {

	void createPdf(List<Transaction> txnList) throws Exception;
}
