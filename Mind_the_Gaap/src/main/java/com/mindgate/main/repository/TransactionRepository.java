package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Transactions;

@Repository
public class TransactionRepository implements TransactionRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String INSERT_NEW_TRANSACTION = "";
	private final static String UPDATE_EXISTING_TRANSACTION = "update transactions set type=?, amount=?,account_id=?, to_account=?, transaction_status=? where tranaction_id=?";
	private final static String DELETE_EXISTING_TRANSACTION = "delete transactions where transaction_id=?";
	private final static String SELECT_ALL_TRANSACTION = "SELECT t.transaction_id, t.date_and_time, t.type, t.transaction_status, t.amount, a1.* ,c1.* ,a2.OPENING_DATE as to_opening_date,a2.MINIMUM_BALANCE as to_minimum_balance, a2.CURRENT_BALANCE as to_CURRENT_BALANCE,a2.RATE_OF_INTEREST as to_RATE_OF_INTEREST,a2.ACCOUNT_ID as to_ACCOUNT_ID,a2.ACCOUNT_TYPE as to_account_type,a2.ACCOUNT_STATUS as to_account_status,a2.CUSTOMER_ID as to_customer_id,c2.FIRST_NAME as to_FIRST_NAME,c2.LAST_NAME as to_LAST_NAME,c2.PASSWORD as to_PASSWORD,c2.USERNAME as to_USERNAME,c2.ADDRESS_LINE_1 as to_ADDRESS_LINE1,c2.ADDRESS_LINE_2 as to_ADDRESS_LINE2,c2.ADDRESS_LINE_3 as to_ADDRESS_LINE3,c2.CITY as to_city,c2.STATE as to_state,c2.ZIP as to_zip,c2.PHONE as to_phone,c2.CELL as to_cell,c2.EMAIL as to_email,c2.CUSTOMER_ID as to_customer_id,c2.CUSTOMER_STATUS as to_CUSTOMER_STATUS FROM  transactions t JOIN account_details a1 ON t.ACCOUNT_ID = a1.account_id JOIN customer_details c1 ON a1.customer_id = c1.customer_id JOIN account_details a2 ON t.to_account = a2.account_id JOIN customer_details c2 ON a2.customer_id = c2.customer_id";
	private final static String SELECT_ONE_TRANSACTION = "SELECT t.transaction_id, t.date_and_time, t.type, t.transaction_status, t.amount, a1.* ,c1.* ,a2.OPENING_DATE as to_opening_date,a2.MINIMUM_BALANCE as to_minimum_balance, a2.CURRENT_BALANCE as to_CURRENT_BALANCE,a2.RATE_OF_INTEREST as to_RATE_OF_INTEREST,a2.ACCOUNT_ID as to_ACCOUNT_ID,a2.ACCOUNT_TYPE as to_account_type,a2.ACCOUNT_STATUS as to_account_status,a2.CUSTOMER_ID as to_customer_id,c2.FIRST_NAME as to_FIRST_NAME,c2.LAST_NAME as to_LAST_NAME,c2.PASSWORD as to_PASSWORD,c2.USERNAME as to_USERNAME,c2.ADDRESS_LINE_1 as to_ADDRESS_LINE1,c2.ADDRESS_LINE_2 as to_ADDRESS_LINE2,c2.ADDRESS_LINE_3 as to_ADDRESS_LINE3,c2.CITY as to_city,c2.STATE as to_state,c2.ZIP as to_zip,c2.PHONE as to_phone,c2.CELL as to_cell,c2.EMAIL as to_email,c2.CUSTOMER_ID as to_customer_id,c2.CUSTOMER_STATUS as to_CUSTOMER_STATUS FROM  transactions t JOIN account_details a1 ON t.ACCOUNT_ID = a1.account_id JOIN customer_details c1 ON a1.customer_id = c1.customer_id JOIN account_details a2 ON t.to_account = a2.account_id JOIN customer_details c2 ON a2.customer_id = c2.customer_id where transaction_id =?";

	
	@Override
	public Transactions getTransactionByTransactionId(int transactionId) {
		TransactionRowMapper transactionRowMapper = new TransactionRowMapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_TRANSACTION, transactionRowMapper, transactionId);
	}
	
	@Override
	public boolean addNewTransaction(Transactions transaction) {
		return false;
	}

	@Override
	public Transactions updateTransaction(Transactions transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTransaction(int transactionId) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public List<Transactions> getAllTransaction() {
		TransactionRowMapper transactionRowMapper = new TransactionRowMapper();
		return jdbcTemplate.query(SELECT_ALL_TRANSACTION, transactionRowMapper);
	}

}
