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
	private final static String UPDATE_EXISTING_CHEQUE = "update cheque set issue_cheque_date = ?, amount = ?, sender_account_id = ?, receiver_account_id = ?, clearance_cheque_date = ?, cheque_status = ? = ? where cheque_id = ?";
	private final static String DELETE_EXISTING_CHEQUE = "delete from cheque where cheque_id=?";
	private final static String SELECT_ALL_CHEQUES = " select cheque_id ,issue_cheque_date,amount,cheque.account_id,receiver_account_id,clearance_cheque_date,cheque_status from cheque left join account_details  on cheque.account_id=account_details.account_id";
	private final static String SELECT_ONE_CHEQUE = " select * from cheque c,account_details a,customer_details c where c.customer_id=a.CUSTOMER_ID and c.account_id=a.account_id and c.receiver_account_id=a.account_id";

	
	@Override
	public List<Cheque> getAllCheque() {
		ChequeRowMapper chequeRowMapper = new ChequeRowMapper();
		return jdbcTemplate.query(SELECT_ALL_CHEQUES, chequeRowMapper);
	}

	@Override
	public boolean addNewCheque(Cheque cheque) {
		Object[] parameters = { cheque.getChequeDate(),cheque.getAmount(),cheque.getSenderAccountId(),cheque.getReceiverAccountId(),cheque.getClearanceChequeDate(),cheque.getChequeStatus()};
		int rowCount = jdbcTemplate.update(INSERT_NEW_CHEQUE, parameters);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public Cheque updateCheque(Cheque cheque) {
		Object[] parameters = { cheque.getChequeDate(),cheque.getAmount(),cheque.getSenderAccountId(),cheque.getReceiverAccountId(),cheque.getClearanceChequeDate(),cheque.getChequeStatus()};
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
		 return jdbcTemplate.queryForObject(SELECT_ONE_CHEQUE,chequeRowMapper, chequeId);
	}

	

}
