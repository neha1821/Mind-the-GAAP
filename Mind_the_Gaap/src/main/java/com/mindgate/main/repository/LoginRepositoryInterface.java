package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.LoginDetails;

public interface LoginRepositoryInterface {

	public boolean addNewLogin(LoginDetails loginDetails);
	public LoginDetails updateLogin(LoginDetails loginDetails);
	public boolean deleteLogin(int loginId);
	public LoginDetails getLoginByLoginId(int loginId);
	public List<LoginDetails> getAllLogins();

	
}
