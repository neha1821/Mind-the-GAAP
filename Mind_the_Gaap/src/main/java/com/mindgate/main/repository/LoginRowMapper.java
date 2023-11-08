package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Customer;
import com.mindgate.main.domain.LoginDetails;

public class LoginRowMapper implements RowMapper<LoginDetails>{

	@Autowired
	Customer customer;
	
	@Override
	public LoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		CustomerRowMapper customerRowMapper=new CustomerRowMapper();
		Customer customer=customerRowMapper.mapRow(rs, rowNum);
		
		int loginId = rs.getInt("login_id");
		int count = rs.getInt("count");
		String loginPassword = rs.getString("password");
		String typeOfMember = rs.getString("type_of_member");
		String loginStatus = rs.getString("login_status");

		LoginDetails loginDetails  = new LoginDetails(loginId, customer, loginPassword, count, typeOfMember, loginStatus);
		return loginDetails;
	}

}
