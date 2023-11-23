package com.mindgate.main.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Account;

@Repository
public class AccountRepository implements AccountRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	int rowCount = 0;
	Account account;
	LocalDate date=LocalDate.now();
	String accountStatus="FAILED";
	
	private AccountRowMapper accountRowMapper;

	private final static String INSERT_NEW_ACCOUNT = "insert into account_details values(?,?,?,?,account_id_sequence.nextVal,?,?,?)";
	private final static String UPDATE_EXISTING_ACCOUNT = "update account_details set OPENING_DATE=? ,MINIMUM_BALANCE=?,CURRENT_BALANCE=?,RATE_OF_INTEREST=?,ACCOUNT_TYPE=?,ACCOUNT_STATUS=? where account_id=?";
	private final static String DELETE_EXISTING_ACCOUNT = "delete from account_details  where account_Id=?";
	private final static String SELECT_ALL_ACCOUNT = "select *  from account_details a,customer_details c where a.customer_id=c.customer_id";
	private final static String SELECT_ONE_ACCOUNT = "select *  from account_details,customer_details where account_details.customer_id=customer_details.customer_id  and account_details.account_id=?";
	private final static String SELECT_ALL_CUSTOMER_ACCOUNT = "select * from account_details a,customer_details c where a.customer_id=c.customer_id and c.customer_id = ?";
	private final static String SELECT_ALLCUSTOMER_BY_STATUS = "select * from account_details a,customer_details c where a.customer_id=c.customer_id and a.account_status='FAILED'";
	private final static String CHANGE_ACCOUNT_STATUS = "update account_details set ACCOUNT_STATUS='CREATED' where account_id=?";

	private final static String CHANGE_AMOUNT_ = "update account_details set  CURRENT_BALANCE=?  where account_id=?";

	
	// select
	// opening_date,minimum_balance,current_balance,rate_of_interest,account_id,account_type,account_status,customer_details.customer_id
	// from account_details,customer_details where
	// account_details.customer_id=customer_details.customer_id and
	// account_details.account_id=?

	@Override
	public Account updateAccount(Account account) {
		Object[] parameters = { account.getDate(), account.getMinimumBalance(), account.getCurrentBalance(),
				account.getRateOfInterest(), account.getAccountType(), account.getAccountStatus(),
				account.getAccountId() };
		System.out.println(account);
		int rowCount = jdbcTemplate.update(UPDATE_EXISTING_ACCOUNT, parameters);
		if (rowCount > 0) {
			return getAccountByAccountId(account.getAccountId());
		}
		return null;
	}

	@Override
	public boolean addNewAccount(Account account) {
		Object[] parameters = { date, account.getMinimumBalance(), account.getCurrentBalance(),
				account.getRateOfInterest(), account.getAccountType(), accountStatus,
				account.getCustomerId().getCustomerId() };
		int rowCount = jdbcTemplate.update(INSERT_NEW_ACCOUNT, parameters);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteAccount(int accountId) {
		int rowCount = jdbcTemplate.update(DELETE_EXISTING_ACCOUNT, accountId);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public Account getAccountByAccountId(int accountId) {
		accountRowMapper = new AccountRowMapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_ACCOUNT, accountRowMapper, accountId);
	}

	@Override
	public List<Account> getAllAccount() {
		accountRowMapper = new AccountRowMapper();
		return jdbcTemplate.query(SELECT_ALL_ACCOUNT, accountRowMapper);
	}

	@Override
	public List<Account> getAccountByCustomerId(int customerId) {
		accountRowMapper = new AccountRowMapper();
		return jdbcTemplate.query(SELECT_ALL_CUSTOMER_ACCOUNT, accountRowMapper, customerId);
	}

	@Override
	public List<Account> getAccountsByAccountStatusFailed() {
		accountRowMapper = new AccountRowMapper();
		return jdbcTemplate.query(SELECT_ALLCUSTOMER_BY_STATUS, accountRowMapper);
		
	}

	@Override
	public boolean changeAccountStatus(int accountId) {
		int rowCount = jdbcTemplate.update(CHANGE_ACCOUNT_STATUS,accountId);
		if (rowCount > 0)
			return true;
		else
			return false;
		
	}

	@Override
	public Account changeAmount(Account account) {
		Object[] parameters = {  account.getCurrentBalance(),
				account.getAccountId() };
		System.out.println(account);
		int rowCount = jdbcTemplate.update(CHANGE_AMOUNT_, parameters);
		if (rowCount > 0) {
			return getAccountByAccountId(account.getAccountId());
		}
		return null;
	}
}
