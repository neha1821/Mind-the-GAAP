package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Cheque;

@Repository
public class ChequeRepository implements ChequeRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String INSERT_NEW_CHEQUE = "insert into cheque values(cheque_id_sequence.nextVal,?,?,?,?,?,?)";
	private final static String UPDATE_EXISTING_CHEQUE = "update cheque set ISSUE_CHEQUE_DATE=?,AMOUNT =?,ACCOUNT_ID=?,RECEIVER_ACCOUNT_ID=?,CLEARANCE_CHEQUE_DATE=?,CHEQUE_STATUS=?  where CHEQUE_ID = ?";
	private final static String DELETE_EXISTING_CHEQUE = "delete from cheque where cheque_id=?";
	private final static String SELECT_ALL_CHEQUES = "select ch.cheque_id,ch.issue_cheque_date,ch.amount,ch.clearance_cheque_date,ch.cheque_status,a1.* ,c1.* ,a2.OPENING_DATE as to_opening_date,a2.MINIMUM_BALANCE as to_minimum_balance, a2.CURRENT_BALANCE as to_CURRENT_BALANCE,a2.RATE_OF_INTEREST as to_RATE_OF_INTEREST,a2.ACCOUNT_ID as to_ACCOUNT_ID,a2.ACCOUNT_TYPE as to_account_type,a2.ACCOUNT_STATUS as to_account_status,a2.CUSTOMER_ID as to_customer_id,c2.FIRST_NAME as to_FIRST_NAME,c2.LAST_NAME as to_LAST_NAME,c2.PASSWORD as to_PASSWORD,c2.USERNAME as to_USERNAME,c2.ADDRESS_LINE_1 as to_ADDRESS_LINE1,c2.ADDRESS_LINE_2 as to_ADDRESS_LINE2,c2.ADDRESS_LINE_3 as to_ADDRESS_LINE3,c2.CITY as to_city,c2.STATE as to_state,c2.ZIP as to_zip,c2.PHONE as to_phone,c2.CELL as to_cell,c2.EMAIL as to_email,c2.CUSTOMER_ID as to_customer_id,c2.CUSTOMER_STATUS as to_CUSTOMER_STATUS FROM  cheque ch JOIN account_details a1 ON ch.ACCOUNT_ID = a1.account_id JOIN customer_details c1 ON a1.customer_id = c1.customer_id JOIN account_details a2 ON ch.receiver_account_id = a2.account_id JOIN customer_details c2 ON a2.customer_id = c2.customer_id";
	private final static String SELECT_ONE_CHEQUE = "select ch.cheque_id,ch.issue_cheque_date,ch.amount,ch.clearance_cheque_date,ch.cheque_status,a1.* ,c1.* ,a2.OPENING_DATE as to_opening_date,a2.MINIMUM_BALANCE as to_minimum_balance, a2.CURRENT_BALANCE as to_CURRENT_BALANCE,a2.RATE_OF_INTEREST as to_RATE_OF_INTEREST,a2.ACCOUNT_ID as to_ACCOUNT_ID,a2.ACCOUNT_TYPE as to_account_type,a2.ACCOUNT_STATUS as to_account_status,a2.CUSTOMER_ID as to_customer_id,c2.FIRST_NAME as to_FIRST_NAME,c2.LAST_NAME as to_LAST_NAME,c2.PASSWORD as to_PASSWORD,c2.USERNAME as to_USERNAME,c2.ADDRESS_LINE_1 as to_ADDRESS_LINE1,c2.ADDRESS_LINE_2 as to_ADDRESS_LINE2,c2.ADDRESS_LINE_3 as to_ADDRESS_LINE3,c2.CITY as to_city,c2.STATE as to_state,c2.ZIP as to_zip,c2.PHONE as to_phone,c2.CELL as to_cell,c2.EMAIL as to_email,c2.CUSTOMER_ID as to_customer_id,c2.CUSTOMER_STATUS as to_CUSTOMER_STATUS FROM  cheque ch JOIN account_details a1 ON ch.ACCOUNT_ID = a1.account_id JOIN customer_details c1 ON a1.customer_id = c1.customer_id JOIN account_details a2 ON ch.receiver_account_id = a2.account_id JOIN customer_details c2 ON a2.customer_id = c2.customer_id where ch.cheque_id=?";
			
	@Override
	public List<Cheque> getAllCheque() {
		ChequeRowMapper chequeRowMapper = new ChequeRowMapper();
		return jdbcTemplate.query(SELECT_ALL_CHEQUES, chequeRowMapper);
	}

	@Override
	public boolean addNewCheque(Cheque cheque) {
		Object[] parameters = { cheque.getChequeDate(), cheque.getAmount(), cheque.getFromAccount(),
				cheque.getToAccountId(), cheque.getClearanceChequeDate(),
				cheque.getChequeStatus() };
		int rowCount = jdbcTemplate.update(INSERT_NEW_CHEQUE, parameters);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public Cheque updateCheque(Cheque cheque) {
		Object[] parameters = { cheque.getChequeDate(), cheque.getAmount(), cheque.getToAccount(),
				cheque.getFromAccount(), cheque.getClearanceChequeDate(), cheque.getChequeStatus(),
				cheque.getChequeId() };
		int rowCount = jdbcTemplate.update(UPDATE_EXISTING_CHEQUE, parameters);
		if (rowCount > 0) {
			return getChequeByChequeId(cheque.getChequeId());
		}
		return null;
	}

	@Override
	public boolean deleteCheque(int chequeId) {
		int rowCount = jdbcTemplate.update(DELETE_EXISTING_CHEQUE, chequeId);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public Cheque getChequeByChequeId(int chequeId) {
		ChequeRowMapper chequeRowMapper = new ChequeRowMapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_CHEQUE, chequeRowMapper, chequeId);
	}

}
