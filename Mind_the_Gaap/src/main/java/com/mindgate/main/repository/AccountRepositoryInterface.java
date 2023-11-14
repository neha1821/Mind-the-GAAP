package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Account;

public interface AccountRepositoryInterface {

	boolean addNewAccount(Account account);
	Account updateAccount(Account account);
	boolean deleteAccount(int accountId);
	Account getAccountByAccountId(int accountId);
	List<Account> getAllAccount();

}
