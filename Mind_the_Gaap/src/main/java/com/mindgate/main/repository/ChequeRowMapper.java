package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Cheque;
import com.mindgate.main.domain.Customer;

public class ChequeRowMapper implements RowMapper<Cheque> {

	@Override
	public Cheque mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CustomerRowMapper customerRowMapper=new CustomerRowMapper();
        Customer customer=customerRowMapper.mapRow(rs, rowNum);
        
        
		AccountRowMapper accountRowMapper = new AccountRowMapper();
		Account account = accountRowMapper.mapRow(rs, rowNum);
		
		int chequeId = rs.getInt("cheque_id");
		 String chequeDate =rs.getString("issue_cheque_date");
		 double amount =rs.getDouble("amount");
		 String clearanceChequeDate = rs.getString("clearance_cheque_date");
		 String chequeStatus = rs.getString("cheque_status");
		 
		 
		 
		 Cheque cheque =new Cheque(chequeId, chequeDate, amount, account, account, clearanceChequeDate, chequeStatus, account);
		 return cheque;
	}
	

}
