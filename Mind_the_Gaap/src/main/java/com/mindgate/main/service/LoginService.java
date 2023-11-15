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
		System.out.println("Updated succesfully...!!!");
		return loginRepositoryInterface.updateLogin(loginDetails);
	}

	@Override
	public boolean deleteLogin(int loginId) {
		return loginRepositoryInterface.deleteLogin(loginId);
	}

	@Override
	public LoginDetails getLoginByLoginId(LoginDetails loginDetails) {
		LoginDetails existingLoginDetails = loginRepositoryInterface.getLoginByLoginId(loginDetails);
		if ((existingLoginDetails.getCount() <= 3 ) && existingLoginDetails.getLoginStatus().equalsIgnoreCase("success") && existingLoginDetails.getPassword().equals(loginDetails.getPassword())) {
//			existingLoginDetails.setPassword("");
			System.out.println("count is increasing....!!!");
			return existingLoginDetails;
		} else {
			if (existingLoginDetails.getCount() < 2) {
				existingLoginDetails.setCount(existingLoginDetails.getCount() + 1);
				updateLogin(existingLoginDetails);
				existingLoginDetails.setPassword("null");
				existingLoginDetails.setLoginStatus("Success");
				loginRepositoryInterface.updateLogin(existingLoginDetails);
				existingLoginDetails.setTypeOfMember("");
				return existingLoginDetails;
			} else {
				existingLoginDetails.setCount(existingLoginDetails.getCount() + 1);
				existingLoginDetails.setLoginStatus("Fail");
				existingLoginDetails.setPassword("null");
				existingLoginDetails.setTypeOfMember("");
				updateLogin(existingLoginDetails);
				loginRepositoryInterface.updateLogin(existingLoginDetails);
				return existingLoginDetails;
			}

		}
	}

	@Override
	public List<LoginDetails> getAllLogins() {
		return loginRepositoryInterface.getAllLogins();
	}

	@Override
	public LoginDetails loginCount(LoginDetails loginDetails) {
		return loginRepositoryInterface.loginCount(loginDetails);
	}

	@Override
	public List<LoginDetails> getInActive() {
		return loginRepositoryInterface.getInActive();

	}

}
