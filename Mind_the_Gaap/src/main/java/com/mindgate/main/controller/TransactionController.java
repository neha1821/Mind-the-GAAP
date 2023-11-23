package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Transactions;
import com.mindgate.main.service.TransactionServiceInterface;

@RestController
@RequestMapping("transactionscrudapi")
@CrossOrigin("*")
public class TransactionController {
	
	@Autowired
	private TransactionServiceInterface transactionServiceInterface;
	
//	("http://localhost:8081/transactionscrudapi/alltransactions")
	@RequestMapping(value = "alltransactions" , method = RequestMethod.GET )
	public List<Transactions> getAllTransactions() {
		System.out.println("All Customers");
		return transactionServiceInterface.getAllTransaction();
	} 
	
	//http://localhost:8081/transactionscrudapi/onetransactionid/100004
	@RequestMapping(value = "onetransactionid/{transactionId}" , method = RequestMethod.GET )
	public Transactions getTransactionByTransactionId(@PathVariable int transactionId) {
		return transactionServiceInterface.getTransactionByTransactionId(transactionId);
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
	
	@RequestMapping(value = "alltransactions/customer/{accountId}" , method = RequestMethod.GET)
	public List<Transactions> getAllTransactionsByCustomer(@PathVariable int accountId){
		System.out.println("All Customers");
		return transactionServiceInterface.getAllTransactionByAccountId(accountId);
	} 
	
	@RequestMapping(value = "alltransactions/account/history" , method = RequestMethod.POST)
	public List<Transactions> getAllTransactionBothDebitCreditByAccountId(@RequestBody Transactions transactions){
		System.out.println("All Customers");
		return transactionServiceInterface.getAllTransactionBothDebitCreditByAccountId(transactions);
	}

	
}
