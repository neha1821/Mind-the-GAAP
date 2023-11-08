package com.mindgate.main.domain;


public class Transactions {
	private int transactionId;
	private String date;
	private String type;//type to deposit or cheque
	private Account accountId;
	private Account toAccount;
	private String transactionStatus;
	private double amount;
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public Transactions(int transactionId, String date, String type, Account accountId, Account toAccount,
			String transactionStatus, double amount) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.type = type;
		this.accountId = accountId;
		this.toAccount = toAccount;
		this.transactionStatus = transactionStatus;
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getAccountId() {
		return accountId;
	}

	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", date=" + date + ", type=" + type + ", accountId="
				+ accountId + ", toAccount=" + toAccount + ", transactionStatus=" + transactionStatus + ", amount="
				+ amount + "]";
	}
	
	
}
