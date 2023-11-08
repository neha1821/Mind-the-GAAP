package com.mindgate.main.domain;

public class LoginDetails {
	private int loginId;
	private Customer customerId;
	private String password;
	private int count;
	private String typeOfMember;
	private String loginStatus;
	
	public LoginDetails() {
		// TODO Auto-generated constructor stub
	}

	public LoginDetails(int loginId, Customer customerId, String password, int count, String typeOfMember,
			String loginStatus) {
		super();
		this.loginId = loginId;
		this.customerId = customerId;
		this.password = password;
		this.count = count;
		this.typeOfMember = typeOfMember;
		this.loginStatus = loginStatus;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getTypeOfMember() {
		return typeOfMember;
	}

	public void setTypeOfMember(String typeOfMember) {
		this.typeOfMember = typeOfMember;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Override
	public String toString() {
		return "LoginDetails [loginId=" + loginId + ", customerId=" + customerId + ", password=" + password + ", count="
				+ count + ", typeOfMember=" + typeOfMember + ", loginStatus=" + loginStatus + "]";
	}
	
	
}
