package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Account;

public interface AccountServiceInterface {

	boolean addNewAccount(Account account);
	Account updateAccount(Account account);
	boolean deleteAccount(int accountId);
	Account getAccountByAccountId(int accountId);
	List<Account> getAllAccount();
}
