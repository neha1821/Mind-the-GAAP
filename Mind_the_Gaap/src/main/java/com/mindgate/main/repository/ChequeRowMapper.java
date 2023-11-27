package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Cheque;
import com.mindgate.main.domain.Customer;

public class ChequeRowMapper implements RowMapper<Cheque> {

	@Override
	public Cheque mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("in ChequeRowMapper");
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
		byte[] fileDetails = rs.getBytes("file_details");

		Customer fromCustomer = new Customer(first_name, last_name, username, password, address_line_1, address_line_2,
				address_line_3, city, state, zip, phone, cell, email, customer_id, customer_status, fileDetails);

		String openingDate = rs.getString("opening_date");
		double minimumBalance = rs.getDouble("minimum_balance");
		double currentBalance = rs.getDouble("current_balance");
		double rateOfInterest = rs.getDouble("rate_of_interest");
		int accountId = rs.getInt("account_id");
		String accountType = rs.getString("account_type");
		String accountStatus = rs.getString("account_status");
		double overDraftBalance = rs.getDouble("over_draft_balance");

		Account fromAccount = new Account(openingDate, minimumBalance, currentBalance, rateOfInterest, accountId,
				accountType, accountStatus, overDraftBalance, fromCustomer);

		System.out.println("From account");
		System.out.println(fromAccount);

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
		byte[] toFileDetails = rs.getBytes("to_file_details");

		Customer toCustomer = new Customer(toFirstName, toLastName, toUsername, toPassword, toAddressLine1,
				toAddressLine2, toAddressLine3, toCity, toState, toZip, toPhone, toCell, toEmail, toCustomerId,
				toCustomerStatus, toFileDetails);

		String toOpeningData = rs.getString("to_opening_date");
		double toMinimumBalance = rs.getDouble("to_minimum_balance");
		double toCurrentBalance = rs.getDouble("to_current_balance");
		double toRateOfInterest = rs.getDouble("to_rate_of_interest");
		int toAccountId = rs.getInt("to_account_id");
		String toAccountType = rs.getString("to_account_type");
		String toAccountStatus = rs.getString("to_account_status");
		double toOverDraftBalance = rs.getDouble("to_over_draft_balance");

		Account toAccount = new Account(toOpeningData, toMinimumBalance, toCurrentBalance, toRateOfInterest,
				toAccountId, toAccountType, toAccountStatus, toOverDraftBalance, toCustomer);
		System.out.println("To Account");
		System.out.println(toAccount);

		int chequeId = rs.getInt("cheque_id");
		String chequeDate = rs.getString("issue_cheque_date");
		double amount = rs.getDouble("amount");
		String clearanceChequeDate = rs.getString("clearance_cheque_date");
		String chequeStatus = rs.getString("cheque_status");

		Cheque cheque = new Cheque(chequeId, chequeDate, amount, toAccount, toAccountId, fromAccount, accountId,
				clearanceChequeDate, chequeStatus);
		return cheque;
	}

}
