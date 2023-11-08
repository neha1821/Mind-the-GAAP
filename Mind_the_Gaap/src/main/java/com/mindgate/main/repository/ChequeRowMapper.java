package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Cheque;
import com.mindgate.main.domain.Customer;

public class ChequeRowMapper implements RowMapper<Cheque> {
@Autowired
private Account account;
	@Override
	public Cheque mapRow(ResultSet rs, int rowNum) throws SQLException {
		String first_name = rs.getString("first_name");
		String last_name = rs.getString("last_name");
		String username = rs.getString("username");
		String password = rs.getString("password");
		String address_line_1 = rs.getString("address_line_1");
		String address_line_2 = rs.getString("address_line_2");
		String address_line_3 = rs.getString("address_line_3");
		String city = rs.getString("city");
		String state = rs.getString("state");
		int zip = rs.getInt("Zip");
		long phone = rs.getLong("phone");
		long cell = rs.getLong("cell");
		String email = rs.getString("email");
		int customer_id = rs.getInt("customer_id");
		String customer_status = rs.getString("customer_status");
		
		Customer customer = new Customer(first_name, last_name, username, password, address_line_1, address_line_2, address_line_3, city, state, zip, phone, cell, email, customer_id, customer_status);
		
		String openingDate =rs.getString("opening_date");
		double minimumBalance=rs.getDouble("minimum_balance");
		double currentBalance =rs.getDouble("current_balance");
		double rateOfInterest=rs.getDouble("rate_of_interest");
		//int accountId =rs.getInt("account_id");
		String accountType =rs.getString("account_type");
		String accountStatus =rs.getString("account_status");
		
		//Account account=new Account(openingDate, minimumBalance, currentBalance, rateOfInterest, accountId, accountType, accountStatus, customer);

		
		int chequeId = rs.getInt("cheque_id");
		 String chequeDate =rs.getString("issue_cheque_date");
		 double amount =rs.getDouble("amount");
		 int accountId = rs.getInt("account_id");
		 int receiverAccountId = rs.getInt("receiver_account_id");
		 
		 Cheque cheque =new Cheque(chequeId, chequeDate, amount, accountId, receiverAccountId, chequeDate, chequeDate,account);
		 return cheque;
	}
	

}
