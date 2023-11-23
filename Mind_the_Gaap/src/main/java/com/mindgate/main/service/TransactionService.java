package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Transactions;
import com.mindgate.main.repository.TransactionRepositoryInterface;

@Service
public class TransactionService implements TransactionServiceInterface{
	
	@Autowired
	TransactionRepositoryInterface transactionRepositoryInterface;

	@Override
	public boolean addNewTransaction(Transactions transaction) {
		// TODO Auto-generated method stub
		return transactionRepositoryInterface.addNewTransaction(transaction);
	}

	@Override
	public Transactions updateTransaction(Transactions transaction) {
		if(transaction.getAmount()<= transaction.getFromAccount().getCurrentBalance()) {
            transaction.getFromAccount().setCurrentBalance(transaction.getFromAccount().getCurrentBalance()-transaction.getAmount());
            transaction.getToAccount().setCurrentBalance(transaction.getToAccount().getCurrentBalance()+transaction.getAmount());
            return transaction;
        }
		return transactionRepositoryInterface.updateTransaction(transaction);
	}

	@Override
	public boolean deleteTransaction(int transactionId) {
		// TODO Auto-generated method stub
		return transactionRepositoryInterface.deleteTransaction(transactionId);
	}

	@Override
	public Transactions getTransactionByTransactionId(int transactionId) {
		return transactionRepositoryInterface.getTransactionByTransactionId(transactionId);
	}

	@Override
	public List<Transactions> getAllTransaction() {
		return transactionRepositoryInterface.getAllTransaction();
	}

	@Override
	public List<Transactions> getAllTransactionByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return transactionRepositoryInterface.getAllTransactionByAccountId(accountId);
	}

	@Override
	public List<Transactions> getAllTransactionBothDebitCreditByAccountId(Transactions transactions) {
		// TODO Auto-generated method stub
		return transactionRepositoryInterface.getAllTransactionBothDebitCreditByAccountId(transactions);
	}

}
