package com.project.banking.customer.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "trannsaction_info")
public class TransactionInfo {
	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	@Column(name = "transaction_type")
	private boolean transactionType; // 0 -> debit 1-> credit
	@Column(name = "transacted_with")
	private int transactedWith;
	@Column(name = "transaction_amount")
	private double transactionAmount;
	@Column(name = "transaction_date")
	@Temporal(TemporalType.DATE)
	private Date transactionDate;
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name ="customer_info_id")
	private CustomerInfo customerInfo;
	

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}



	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	



	public TransactionInfo(boolean transactionType, int transactedWith, double transactionAmount, Date transactionDate,
			String status, CustomerInfo customerInfo) {
		super();
		this.transactionType = transactionType;
		this.transactedWith = transactedWith;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.status = status;
		this.customerInfo = customerInfo;
	}
	
	public int getCustomerId() {
		return getCustomerInfo().getCustomerId();
	}
	

	public int getTransactedWith() {
		return transactedWith;
	}



	public void setTransactedWith(int transactedWith) {
		this.transactedWith = transactedWith;
	}



	public TransactionInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean getTransactionType() {
		return this.transactionType;
	}

	public boolean isTransactionType() {
		return transactionType;
	}

	public void setTransactionType(boolean transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
