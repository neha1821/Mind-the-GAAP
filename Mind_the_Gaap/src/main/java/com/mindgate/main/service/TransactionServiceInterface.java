package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Transactions;

public interface TransactionServiceInterface {
	
	public boolean addNewTransaction(Transactions transaction);

	public Transactions updateTransaction(Transactions transaction);

	public boolean deleteTransaction(int transactionId);

	public Transactions getTransactionByTransactionId(int transactionId);

	public List<Transactions> getAllTransaction();
	
	public List<Transactions> getAllTransactionByAccountId(int accountId);
	public List<Transactions> getAllTransactionBothDebitCreditByAccountId(Transactions transactions);


}
