package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Account;
@Repository
public class AccountRepository implements AccountRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	int rowCount=0;
	Account account;
	private AccountRowMapper accountRowMapper;
	
	private final static String INSERT_NEW_ACCOUNT = "insert into account_details values(?,?,?)";
	private final static String UPDATE_EXISTING_ACCOUNT = "update employee_details set name=? ,salary=? where employee_id=?";
	private final static String DELETE_EXISTING_ACCOUNT = "delete from employee_details  where employee_Id=?";
	private final static String SELECT_ALL_ACCOUNT = "select *  from account_details,customer_details where account_details.customer_id=customer_details.customer_id";
	private final static String SELECT_ONE_ACCOUNT = "select  opening_date,minimum_balance,current_balance,rate_of_interest,account_id,account_type,account_status,customer_details.customer_id  from account_details,customer_details where account_details.customer_id=customer_details.customer_id and account_details.account_id=?";


	@Override
	public boolean addNewAccount(Account account) {
		return false;
	}

	@Override
	public Account updateAccount(Account account) {
		return null;
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
		accountRowMapper=new AccountRowMapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_ACCOUNT, accountRowMapper,accountId);
	}

	@Override
	public List<Account> getAllAccount() {
		accountRowMapper=new AccountRowMapper();
		
		
		return jdbcTemplate.query(SELECT_ALL_ACCOUNT,accountRowMapper);
	}

}
