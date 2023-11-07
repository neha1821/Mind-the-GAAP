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
	
	private final static String INSERT_NEW_LOGIN = "insert into login_details values(login_id_sequence.nextVal,?,?,?,?,?)";
	private final static String UPDATE_EXISTING_LOGIN = "update login_details set password = ?,count=?, type_of_member=?, login_status = ? where login_id = ?";
	private final static String DELETE_EXISTING_LOGIN = "delete from login_details where login_id=?";
	private final static String SELECT_ALL_LOGINS = "select * from login_details";
	private final static String SELECT_ONE_LOGIN = " select * from login_details where login_id = ?";

	
	@Override
	public boolean addNewLogin(LoginDetails loginDetails) {
		Object[] parameters = { loginDetails.getCustomerId(),loginDetails.getPassword(),loginDetails.getCount(),loginDetails.getTypeOfMember(),loginDetails.getLoginStatus()};
		int rowCount = jdbcTemplate.update(INSERT_NEW_LOGIN, parameters);
		if (rowCount > 0)
			return true;
		else
			return false;	}

	@Override
	public LoginDetails updateLogin(LoginDetails loginDetails) {
		Object[] parameters = {loginDetails.getLoginId(),loginDetails.getCustomerId(),loginDetails.getPassword(),loginDetails.getCount(),loginDetails.getTypeOfMember(),loginDetails.getLoginStatus() };
		int rowCount = jdbcTemplate.update(UPDATE_EXISTING_LOGIN, parameters);
		if (rowCount > 0) {
			return getLoginByLoginId(loginDetails.getLoginId());
		}
		return null;
	}

	@Override
	public boolean deleteLogin(int loginId) {
		int rowCount = jdbcTemplate.update(DELETE_EXISTING_LOGIN, loginId);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public LoginDetails getLoginByLoginId(int loginId) {
		LoginRowMapper loginRowMapper = new LoginRowMapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_LOGIN,loginRowMapper, loginId);

	}

	@Override
	public List<LoginDetails> getAllLogins() {
		LoginRowMapper loginRowMapper = new LoginRowMapper();
		return jdbcTemplate.query(SELECT_ALL_LOGINS, loginRowMapper);

	}

}
