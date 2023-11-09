package com.mindgate.main.domain;


public class Transactions {
	private int transactionId;
	private String date;
	private String type;//type to deposit or cheque
	private Account fromAccount;
	private int fromAccountId;
	private Account toAccount;
	private int toAccountId;
	private String transactionStatus;
	private double amount;
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public Transactions(int transactionId, String date, String type, Account fromAccount, int fromAccountId,
			Account toAccount, int toAccountId, String transactionStatus, double amount) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.type = type;
		this.fromAccount = fromAccount;
		this.fromAccountId = fromAccountId;
		this.toAccount = toAccount;
		this.toAccountId = toAccountId;
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

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public int getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(int fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	public int getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(int toAccountId) {
		this.toAccountId = toAccountId;
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
		return "Transactions [transactionId=" + transactionId + ", date=" + date + ", type=" + type + ", fromAccount="
				+ fromAccount + ", fromAccountId=" + fromAccountId + ", toAccount=" + toAccount + ", toAccountId="
				+ toAccountId + ", transactionStatus=" + transactionStatus + ", amount=" + amount + "]";
	}
	
	
}
