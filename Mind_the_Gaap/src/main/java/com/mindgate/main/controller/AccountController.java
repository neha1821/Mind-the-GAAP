package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Customer;
import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.service.AccountServiceInterface;
import com.mindgate.main.service.EmailSenderService;

@RestController
@RequestMapping("accountapi")
@CrossOrigin("*")
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
	
	@RequestMapping(value = "account/{accountId}" , method = RequestMethod.DELETE)
	public boolean deleteCustomer(@PathVariable int accountId) {
		return accountServiceInterface.deleteAccount(accountId);
	}

	@RequestMapping(value = "accounts", method = RequestMethod.GET)
	public List<Account> getAllAccount() {
		return accountServiceInterface.getAllAccount();
	}

	@RequestMapping(value = "accountdetails/{accountId}", method = RequestMethod.GET)
	public Account accountOne(@PathVariable int accountId) {
		return accountServiceInterface.getAccountByAccountId(accountId);
	}

	@RequestMapping(value = "account/{customerId}", method = RequestMethod.GET)
	public List<Account> getAccountByCustomerId(@PathVariable int customerId){
		return accountServiceInterface.getAccountByCustomerId(customerId);
	}
	
	@RequestMapping(value = "accountsByStatus", method = RequestMethod.GET)
	public List<Account> getAccountsByStatus(){
		return accountServiceInterface.getAccountsByAccountStatusFailed();
	}
	
	@RequestMapping(value = "accountstatus/{accountId}" , method = RequestMethod.GET)
	public boolean changeAccountStatus(@PathVariable int accountId) {
		return accountServiceInterface.changeAccountStatus(accountId);
	}
	
	@RequestMapping(value = "account/amountTransfer" , method = RequestMethod.PUT)
	public Account updateAmount(@RequestBody Account account) {
		return accountServiceInterface.changeAmount(account);
	}
	
}
