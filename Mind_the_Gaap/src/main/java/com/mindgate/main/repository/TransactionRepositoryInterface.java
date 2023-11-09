package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Transactions;

public interface TransactionRepositoryInterface {

	public boolean addNewTransaction(Transactions transaction);

	public Transactions updateTransaction(Transactions transaction);

	public boolean deleteTransaction(int transactionId);

	public Transactions getTransactionByTransactionId(int transactionId);

	public List<Transactions> getAllTransaction();

}
