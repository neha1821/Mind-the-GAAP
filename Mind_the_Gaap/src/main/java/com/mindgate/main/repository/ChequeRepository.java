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
	
	private final static String INSERT_NEW_CHEQUE = "insert into cheque_details values(chequeS_id_sequence.nextVal,?,?,?,?,?,?)";
	private final static String UPDATE_EXISTING_CHEQUE = "update cheque_details set issue_cheque_date = ?, amount = ?, sender_account_id = ?, receiver_account_id = ?, clearance_cheque_date = ?, cheque_status = ? = ? where cheque_id = ?";
	private final static String DELETE_EXISTING_CHEQUE = "delete from cheque_details where cheque_Id=?";
	private final static String SELECT_ALL_CHEQUES = "select * from cheque_details";
	private final static String SELECT_ONE_CHEQUE = " select * from cheque_details where cheque_Id = ?";


	@Override
	public boolean addNewCheque(Cheque cheque) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cheque updateCheque(Cheque cheque) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCheque(int chequeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cheque getChequeByChequeId(int chequeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> getAllCheque() {
		// TODO Auto-generated method stub
		return null;
	}

}
