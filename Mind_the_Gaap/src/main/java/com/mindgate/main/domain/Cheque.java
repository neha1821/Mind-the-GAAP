package com.mindgate.main.domain;

import java.util.Objects;

public class Cheque {
	private int chequeId;
	private String chequeDate;
	private double amount;
	private Account fromAccount;
	private int fromAccountId;
	private Account toAccount;
	private int toAccountId;
	private String clearanceChequeDate;
	private String chequeStatus;

	public Cheque() {
		// TODO Auto-generated constructor stub
	}
	

	public Cheque(int chequeId, String chequeDate, double amount, Account toAccount, int toAccountId,
			Account fromAccount, int fromAccountId, String clearanceChequeDate, String chequeStatus) {
		super();
		this.chequeId = chequeId;
		this.chequeDate = chequeDate;
		this.amount = amount;
		this.fromAccount = fromAccount;
		this.fromAccountId = fromAccountId;
		this.toAccount = toAccount;
		this.toAccountId = toAccountId;
		this.clearanceChequeDate = clearanceChequeDate;
		this.chequeStatus = chequeStatus;
	}



	

	public int getChequeId() {
		return chequeId;
	}

	public void setChequeId(int chequeId) {
		this.chequeId = chequeId;
	}

	public String getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public String getClearanceChequeDate() {
		return clearanceChequeDate;
	}

	public void setClearanceChequeDate(String clearanceChequeDate) {
		this.clearanceChequeDate = clearanceChequeDate;
	}

	public String getChequeStatus() {
		return chequeStatus;
	}

	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}



	@Override
	public String toString() {
		return "Cheque [chequeId=" + chequeId + ", chequeDate=" + chequeDate + ", amount=" + amount + ", fromAccount="
				+ fromAccount + ", fromAccountId=" + fromAccountId + ", toAccount=" + toAccount + ", toAccountId="
				+ toAccountId + ", clearanceChequeDate=" + clearanceChequeDate + ", chequeStatus=" + chequeStatus + "]";
	}
	
	

	
}