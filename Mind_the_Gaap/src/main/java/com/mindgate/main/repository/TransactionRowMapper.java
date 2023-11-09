package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Customer;
import com.mindgate.main.domain.Transactions;

public class TransactionRowMapper implements RowMapper<Transactions> {

	@Override
	public Transactions mapRow(ResultSet rs, int rowNum) throws SQLException {
//		
//		ResultSetMetaData rsmd = rs.getMetaData();
//		int columnsNumber = rsmd.getColumnCount();
//		while (rs.next()) {
//		    for (int i = 1; i <= columnsNumber; i++) {
//		        if (i > 1) System.out.print(", ");
//		        String columnValue = rs.getString(i);
//		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
//		    }
//		    System.out.println("");
//		}

		String firstname = rs.getString("first_name");
		System.out.println(rs.getString("first_name"));
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
		
		Customer fromCustomer = new Customer(firstname, last_name, username, password, address_line_1, address_line_2, address_line_3, city, state, zip, phone, cell, email, customer_id, customer_status);
		System.out.println(fromCustomer);
		// Account details rowMapper
		String openingData = rs.getString("opening_date");
		double minimumBalance = rs.getDouble("minimum_balance");
		double currentBalance = rs.getDouble("current_balance");
		double rateOfInterest = rs.getDouble("rate_of_interest");
		int accountId = rs.getInt("account_id");
		String accountType = rs.getString("account_type");
		String accountStatus = rs.getString("account_status");
		
		Account fromAccount = new Account(openingData, minimumBalance, currentBalance, rateOfInterest, accountId,
				accountType, accountStatus, fromCustomer);

		// Customer details rowMapper
		String toFirstName = rs.getString("to_first_name");
		String toLastName = rs.getString("to_last_name");
		String toUsername = rs.getString("to_username");
		String toPassword = rs.getString("to_password");
		String toAddressLine1 = rs.getString("to_address_line1");
		String toAddressLine2 = rs.getString("to_address_line2");
		String toAddressLine3 = rs.getString("to_address_line3");
		String toCity = rs.getString("to_city");
		String toState = rs.getString("to_state");
		int toZip = rs.getInt("to_Zip");
		long toPhone = rs.getLong("to_phone");
		long toCell = rs.getLong("to_cell");
		String toEmail = rs.getString("to_email");
		int toCustomerId = rs.getInt("to_customer_id");
		String toCustomerStatus = rs.getString("to_customer_status");

		Customer toCustomer = new Customer(toFirstName, toLastName, toUsername, toPassword, toAddressLine1, toAddressLine2, 
				toAddressLine3, toCity, toState, toZip, toPhone, toCell, toEmail, toCustomerId, toCustomerStatus);
		
		String toOpeningData = rs.getString("to_opening_date");
		double toMinimumBalance = rs.getDouble("to_minimum_balance");
		double toCurrentBalance = rs.getDouble("to_current_balance");
		double toRateOfInterest = rs.getDouble("to_rate_of_interest");
		int toAccountId = rs.getInt("to_account_id");
		String toAccountType = rs.getString("to_account_type");
		String toAccountStatus = rs.getString("to_account_status");

		Account toAccount =new Account(toOpeningData, toMinimumBalance, toCurrentBalance, toRateOfInterest, toAccountId, toAccountType, toAccountStatus, toCustomer);

		int transactionId = rs.getInt("transaction_id");
		String date = rs.getString("date_and_time");
		String transactionType = rs.getString("type");
		double amount = rs.getDouble("amount");
		String transactionStatus = rs.getString("transaction_status");

		Transactions transactions = new Transactions(transactionId, date, transactionType, fromAccount, accountId, toAccount, toAccountId, transactionStatus, amount);
		System.out.println("Transaction");
		return transactions;
		
	}

}
