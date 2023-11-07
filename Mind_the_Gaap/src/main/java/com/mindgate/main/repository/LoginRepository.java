package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.LoginDetails;

@Repository
public class LoginRepository implements LoginRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String INSERT_NEW_LOGIN = "insert into login_details values(login_id_sequence.nextVal,?,?,?,?)";
	private final static String UPDATE_EXISTING_LOGIN = "update login_details set password = ?,count=?, typeOfMember=?, loginStatus = ? where loginId = ?";
	private final static String DELETE_EXISTING_LOGIN = "delete from login_details where login_Id=?";
	private final static String SELECT_ALL_LOGINS = "select * from login_details";
	private final static String SELECT_ONE_LOGIN = " select * from login_details where login_Id = ?";

	
	@Override
	public boolean addNewLogin(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoginDetails updateLogin(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteLogin(int loginId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoginDetails getLoginByLoginId(int loginId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoginDetails> getAllLogins() {
		// TODO Auto-generated method stub
		return null;
	}

}
