package com.mindgate.main.domain;

public class Account {

	private String date;

	private double minimumBalance;
	private double currentBalance;
	private double rateOfInterest;
	private int accountId;
	private String accountType;
	private String accountStatus;
	private double overDraftBalance;
	private Customer customerId;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String date, double minimumBalance, double currentBalance, double rateOfInterest, int accountId,
			String accountType, String accountStatus, double overDraftBalance, Customer customerId) {
		super();
		this.date = date;
		this.minimumBalance = minimumBalance;
		this.currentBalance = currentBalance;
		this.rateOfInterest = rateOfInterest;
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.overDraftBalance = overDraftBalance;
		this.customerId = customerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public double getOverDraftBalance() {
		return overDraftBalance;
	}

	public void setOverDraftBalance(double overDraftBalance) {
		this.overDraftBalance = overDraftBalance;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Account [date=" + date + ", minimumBalance=" + minimumBalance + ", currentBalance=" + currentBalance
				+ ", rateOfInterest=" + rateOfInterest + ", accountId=" + accountId + ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + ", overDraftBalance=" + overDraftBalance + ", customerId="
				+ customerId + "]";
	} 
	
	
	

}
