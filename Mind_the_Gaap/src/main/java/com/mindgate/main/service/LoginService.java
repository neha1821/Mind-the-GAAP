package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.repository.LoginRepositoryInterface;

@Service
public class LoginService implements LoginServiceInterface {

	@Autowired
	private LoginRepositoryInterface loginRepositoryInterface;
	
	@Override
	public boolean addNewLogin(LoginDetails loginDetails) {
		return loginRepositoryInterface.addNewLogin(loginDetails);
	}

	@Override
	public LoginDetails updateLogin(LoginDetails loginDetails) {
		return loginRepositoryInterface.updateLogin(loginDetails);
	}

	@Override
	public boolean deleteLogin(int loginId) {
		return loginRepositoryInterface.deleteLogin(loginId);
	}

	@Override
	public LoginDetails getLoginByLoginId(int loginId) {
		return loginRepositoryInterface.getLoginByLoginId(loginId);
	}

	@Override
	public List<LoginDetails> getAllLogins() {
		return loginRepositoryInterface.getAllLogins();
	}

}
