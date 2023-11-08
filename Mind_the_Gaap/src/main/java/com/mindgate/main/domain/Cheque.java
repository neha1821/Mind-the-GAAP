package com.mindgate.main.domain;

import java.util.Objects;

public class Cheque {
	private int chequeId;
	private String chequeDate;
	private double amount;
	private int accountId;
	private Account account;
	private Account receiverAccountId;
	private String clearanceChequeDate;
	private String chequeStatus;

	public Cheque() {
		// TODO Auto-generated constructor stub
	}

	public Cheque(int chequeId, String chequeDate, double amount, int accountId, Account account,
			Account receiverAccountId, String clearanceChequeDate, String chequeStatus) {
		super();
		this.chequeId = chequeId;
		this.chequeDate = chequeDate;
		this.amount = amount;
		this.accountId = accountId;
		this.account = account;
		this.receiverAccountId = receiverAccountId;
		this.clearanceChequeDate = clearanceChequeDate;
		this.chequeStatus = chequeStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, accountId, amount, chequeDate, chequeId, chequeStatus, clearanceChequeDate,
				receiverAccountId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cheque other = (Cheque) obj;
		return Objects.equals(account, other.account) && accountId == other.accountId
				&& Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(chequeDate, other.chequeDate) && chequeId == other.chequeId
				&& Objects.equals(chequeStatus, other.chequeStatus)
				&& Objects.equals(clearanceChequeDate, other.clearanceChequeDate)
				&& Objects.equals(receiverAccountId, other.receiverAccountId);
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

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(Account receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
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
		return "Cheque [chequeId=" + chequeId + ", chequeDate=" + chequeDate + ", amount=" + amount + ", accountId="
				+ accountId + ", account=" + account + ", receiverAccountId=" + receiverAccountId
				+ ", clearanceChequeDate=" + clearanceChequeDate + ", chequeStatus=" + chequeStatus + "]";
	}

	
}