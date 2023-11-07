package com.mindgate.main.domain;

public class Cheque {
	private int chequeId;
	private String chequeDate;
	private double amount;
	private int senderAccountId;
	private int receiverAccountId;
	
	public Cheque() {
		// TODO Auto-generated constructor stub
	}

	public Cheque(int chequeId, String chequeDate, double amount, int senderAccountId, int receiverAccountId) {
		super();
		this.chequeId = chequeId;
		this.chequeDate = chequeDate;
		this.amount = amount;
		this.senderAccountId = senderAccountId;
		this.receiverAccountId = receiverAccountId;
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

	public int getSenderAccountId() {
		return senderAccountId;
	}

	public void setSenderAccountId(int senderAccountId) {
		this.senderAccountId = senderAccountId;
	}

	public int getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(int receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}

	@Override
	public String toString() {
		return "Cheque [chequeId=" + chequeId + ", chequeDate=" + chequeDate + ", amount=" + amount
				+ ", senderAccountId=" + senderAccountId + ", receiverAccountId=" + receiverAccountId + "]";
	}	
}
