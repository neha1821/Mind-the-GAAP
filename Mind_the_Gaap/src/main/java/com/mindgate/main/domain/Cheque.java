package com.mindgate.main.domain;

public class Cheque {
	private int chequeId;
	private String chequeDate;
	private double amount;
	private Account senderAccountId;
	private Account receiverAccountId;
	private String clearanceChequeDate;
	private String chequeStatus;
	
	public Cheque() {
		// TODO Auto-generated constructor stub
	}

	public Cheque(int chequeId, String chequeDate, double amount, Account senderAccountId, Account receiverAccountId,
			String clearanceChequeDate, String chequeStatus) {
		super();
		this.chequeId = chequeId;
		this.chequeDate = chequeDate;
		this.amount = amount;
		this.senderAccountId = senderAccountId;
		this.receiverAccountId = receiverAccountId;
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

	public Account getSenderAccountId() {
		return senderAccountId;
	}

	public void setSenderAccountId(Account senderAccountId) {
		this.senderAccountId = senderAccountId;
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
		return "Cheque [chequeId=" + chequeId + ", chequeDate=" + chequeDate + ", amount=" + amount
				+ ", senderAccountId=" + senderAccountId + ", receiverAccountId=" + receiverAccountId
				+ ", clearanceChequeDate=" + clearanceChequeDate + ", chequeStatus=" + chequeStatus + "]";
	}
	
	
	
}	