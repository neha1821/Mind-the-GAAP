package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Transactions;
import com.mindgate.main.repository.TransactionRepositoryInterface;

@Service
public class TransactionService implements TransactionServiceInterface{
	
	@Autowired
	TransactionRepositoryInterface transactionRepositoryInterface;

	@Override
	public boolean addNewTransaction(Transactions transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Transactions updateTransaction(Transactions transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTransaction(int transactionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Transactions getTransactionByTransactionId(int transactionId) {
		return transactionRepositoryInterface.getTransactionByTransactionId(transactionId);
	}

	@Override
	public List<Transactions> getAllTransaction() {
		return transactionRepositoryInterface.getAllTransaction();
	}

}
