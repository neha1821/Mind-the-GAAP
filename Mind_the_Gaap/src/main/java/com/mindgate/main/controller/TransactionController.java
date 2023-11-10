package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//http://localhost:8081/transactionscrudapi/onetransactionid/100004
	@RequestMapping(value = "onetransactionid/{transaction_id}" , method = RequestMethod.GET )
	public Transactions getTransactionByTransactionId(@PathVariable int transaction_id) {
		return transactionServiceInterface.getTransactionByTransactionId(transaction_id);
	} 
	


	//http://localhost:8081/transactionscrudapi/updateTransaction
	@RequestMapping(value = "updateTransaction", method = RequestMethod.PUT)
	public Transactions updateTransaction(@RequestBody Transactions transactions) {
		return transactionServiceInterface.updateTransaction(transactions);
	}
	//http://localhost:8081/transactionscrudapi/addNewTransaction
	@RequestMapping(value = "addNewTransaction", method = RequestMethod.POST)
	public boolean addNewTransaction(@RequestBody Transactions transactions) {
		return transactionServiceInterface.addNewTransaction(transactions);
	}
	//http://localhost:8081/transactionscrudapi/deleteTransaction/100023
	@RequestMapping(value = "deleteTransaction/{transactionId}",method = RequestMethod.DELETE)
	public boolean deleteTransaction(@PathVariable int transactionId) {
		return transactionServiceInterface.deleteTransaction(transactionId);
	}

	
}
