package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Account;

public interface AccountRepositoryInterface {

	boolean addNewAccount(Account account);
	Account updateAccount(Account account);
	boolean deleteAccount(int accountId);
	Account getAccountByAccountId(int accountId);
	List<Account> getAllAccount();
	List<Account> getAccountByCustomerId(int customerId);
	List<Account> getAccountsByAccountStatusFailed();
	boolean changeAccountStatus(int accountId);
	Account changeAmount(Account account);
	

}
