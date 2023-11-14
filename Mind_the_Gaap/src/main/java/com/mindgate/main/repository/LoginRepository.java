package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.LoginDetails;

@Repository
public class LoginRepository implements LoginRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	int rowCount=0;
	LoginDetails loginDetails;
	private LoginRowMapper loginRowMapper;
	
	private final static String INSERT_NEW_LOGIN = "insert into login_details values(login_id_sequence.nextVal,?,?,?,?,?)";
	private final static String UPDATE_EXISTING_LOGIN = "update login_details set password = ?,count=?, type_of_member=?, Login_Status = ? where login_id = ?";
	private final static String DELETE_EXISTING_LOGIN = "delete from login_details where login_id =?";
	private final static String SELECT_ALL_LOGINS = "select * from login_details a,customer_details c where a.customer_id=c.customer_id";
	private final static String SELECT_ONE_LOGIN =  " select *  from login_details,customer_details where login_details.customer_id=customer_details.customer_id  and login_details.login_id=?";
	private final static String SELECT_LOGIN = "select * from login_details where login_id = ? and password = ?";
    private final static String SELECT_INACTIVE_LOGINS = "select * from login_details where Login_Status =  'false' ";
	
	@Override
	public boolean addNewLogin(LoginDetails loginDetails) {
		Object[] parameters =  { loginDetails.getCustomerId().getCustomerId(),loginDetails.getPassword(),loginDetails.getCount(),loginDetails.getTypeOfMember(),loginDetails.getLoginStatus()};
		int rowCount = jdbcTemplate.update(INSERT_NEW_LOGIN, parameters);
		if (rowCount > 0)
			return true;
		else
			return false;	}

	@Override
	public LoginDetails updateLogin(LoginDetails loginDetails) {
		Object[] parameters = {loginDetails.getPassword(),loginDetails.getCount(),loginDetails.getTypeOfMember(),loginDetails.getLoginStatus(),loginDetails.getLoginId() };
		int rowCount = jdbcTemplate.update(UPDATE_EXISTING_LOGIN, parameters);
		if (rowCount > 0) {
			return getLoginByLoginId(loginDetails);
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
	public LoginDetails getLoginByLoginId(LoginDetails loginDetails) {
		LoginRowMapper loginRowMapper = new LoginRowMapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_LOGIN,loginRowMapper,loginDetails.getLoginId());

	}

	@Override
	public List<LoginDetails> getAllLogins() {
		LoginRowMapper loginRowMapper = new LoginRowMapper();
		System.out.println("hii");
		return jdbcTemplate.query(SELECT_ALL_LOGINS, loginRowMapper);

	}
	@Override
    public LoginDetails loginCount(LoginDetails loginDetails) {
        LoginRowMapper loginRowMapper = new LoginRowMapper();
        Object[] parameters = { loginDetails.getLoginId(), loginDetails.getPassword() };
        LoginDetails loginDetails2 = jdbcTemplate.queryForObject(SELECT_LOGIN, loginRowMapper, parameters);
        return loginDetails2;
    }

    @Override
    public List<LoginDetails> getInActive() {
        LoginRowMapper loginDetailsRowMapper = new LoginRowMapper();
        return jdbcTemplate.query(SELECT_INACTIVE_LOGINS, loginDetailsRowMapper);
    }

}
