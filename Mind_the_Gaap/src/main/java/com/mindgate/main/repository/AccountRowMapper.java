package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Customer;


public class AccountRowMapper implements RowMapper<Account>{
	
	@Autowired
	Customer customer;



	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {



		
		
		
		
		String openingDate =rs.getString("opening_date");
		double minimumBalance=rs.getDouble("minimum_balance");
		double currentBalance =rs.getDouble("current_balance");
		double rateOfInterest=rs.getDouble("rate_of_interest");
		int accountId =rs.getInt("account_id");
		String accountType =rs.getString("account_type");
		String accountStatus =rs.getString("account_status");
		
		
		Account account=new Account(openingDate, minimumBalance, currentBalance, rateOfInterest, accountId, accountType, accountStatus, customer);
		
		return account;
		
		

	}
}
