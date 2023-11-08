package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Customer;
import com.mindgate.main.service.AccountServiceInterface;

@RestController
@RequestMapping("accountapi")
public class AccountController {

	@Autowired
	AccountServiceInterface accountServiceInterface;
	
	
	
	@RequestMapping(value = "accounts" , method = RequestMethod.POST )
	public boolean addNewAccount(@RequestBody Account account) {
		return accountServiceInterface.addNewAccount(account);
	}
	
	@RequestMapping(value = "accounts" , method = RequestMethod.PUT)
	public Account updateAccount(@RequestBody Account account) {
		return accountServiceInterface.updateAccount(account);
	}
	
	@RequestMapping(value = "account/{account_id}" , method = RequestMethod.DELETE)
	public boolean deleteCustomer(@PathVariable int account_id) {
		return accountServiceInterface.deleteAccount(account_id);
	}

	@RequestMapping(value = "accounts", method = RequestMethod.GET)
	public List<Account> getAllAccount() {
		return accountServiceInterface.getAllAccount();
	}

	@RequestMapping(value = "account/{accountId}", method = RequestMethod.GET)
	public Account accountOne(@PathVariable int accountId) {
		return accountServiceInterface.getAccountByAccountId(accountId);
	}

}
