package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Cheque;

public class ChequeRowMapper implements RowMapper<Cheque> {

	@Override
	public Cheque mapRow(ResultSet rs, int rowNum) throws SQLException {
		int chequeId = rs.getInt("cheque_id");
		 String chequeDate =rs.getString("issue_cheque_date");
		 double amount =rs.getDouble("amount");
		 int senderAccountId = rs.getInt("sender_account_id");
		 int receiverAccountId = rs.getInt("receiver_account_id");
		 
		 Cheque cheque =new Cheque(chequeId, chequeDate, amount, null, null, chequeDate, chequeDate);
		 return cheque;
	}
	

}
