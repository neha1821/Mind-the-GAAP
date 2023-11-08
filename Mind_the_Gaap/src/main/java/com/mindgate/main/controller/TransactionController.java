package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Transactions;
import com.mindgate.main.service.TransactionServiceInterface;

@RestController
@RequestMapping("transactionscrudapi")
public class TransactionController {
	
	@Autowired
	private TransactionServiceInterface transactionServiceInterface;
	
//	("http://localhost:8082/transactionscrudapi/alltransactions")
	@RequestMapping(value = "alltransactions" , method = RequestMethod.GET )
	public List<Transactions> getAllTransactions() {
		System.out.println("All Customers");
		return transactionServiceInterface.getAllTransaction();
	} 
	
	@RequestMapping(value = "onetransactionid/{transaction_id}" , method = RequestMethod.GET )
	public Transactions getTransactionByTransactionId(@PathVariable int transaction_id) {
		return transactionServiceInterface.getTransactionByTransactionId(transaction_id);
	} 
	

	
}
