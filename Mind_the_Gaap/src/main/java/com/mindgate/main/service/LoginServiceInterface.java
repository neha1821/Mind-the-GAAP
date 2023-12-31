package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.LoginDetails;

public interface LoginServiceInterface {

	public boolean addNewLogin(LoginDetails loginDetails);
	public LoginDetails updateLogin(LoginDetails loginDetails);
	public boolean deleteLogin(int loginId);
	public LoginDetails getLoginByLoginId(LoginDetails loginDetails);
	public List<LoginDetails> getAllLogins();
	public LoginDetails loginCount(LoginDetails loginDetails);

    public List<LoginDetails> getInActive();
    public LoginDetails setLoginByCustomerId(LoginDetails loginDetails);
    
    public boolean getAdminLoginByAdminLoginId(LoginDetails loginDetails);
    public boolean setLoginCountPasswordType(int loginId );
    
    public List<LoginDetails> getLoginsByLoginStatusBlocked();
    
	public LoginDetails AdminGetLoginByLoginId(int loginId);
	
	public LoginDetails getLoginByCustomerId(int customerId);








}
