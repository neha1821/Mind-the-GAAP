package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Account;
import com.mindgate.main.repository.AccountRepositoryInterface;

@Service 
public class AccountService implements AccountServiceInterface {
	
	@Autowired
	private AccountRepositoryInterface accountRepositoryInterface;
	
	

	@Override
	public boolean addNewAccount(Account account) {
		
		return accountRepositoryInterface.addNewAccount(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountRepositoryInterface.updateAccount(account);
	}

	@Override
	public boolean deleteAccount(int accountId) {
		return accountRepositoryInterface.deleteAccount(accountId);
		
	}

	@Override
	public Account getAccountByAccountId(int accountId) {
		return accountRepositoryInterface.getAccountByAccountId(accountId);
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepositoryInterface.getAllAccount();
				
	}

	@Override
	public List<Account> getAccountByCustomerId(int customerId) {
		return accountRepositoryInterface.getAccountByCustomerId(customerId);
	}

	@Override
	public List<Account> getAccountsByAccountStatusFailed() {
		
		return accountRepositoryInterface.getAccountsByAccountStatusFailed();
	}

	@Override
	public boolean changeAccountStatus(int accountId) {
		
		return accountRepositoryInterface.changeAccountStatus(accountId);
	}

	@Override
	public Account changeAmount(Account account) {
		// TODO Auto-generated method stub
		return accountRepositoryInterface.changeAmount(account);
	}

}
