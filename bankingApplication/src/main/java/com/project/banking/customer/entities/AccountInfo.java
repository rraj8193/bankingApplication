package com.project.banking.customer.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_info")
public class AccountInfo {
	@Id
	@Column(name = "account_info_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountInfoId;
	@Column(name = "account_balance")
	private double accountBalance;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "customer_info_id")
	private CustomerInfo customerInfo;

	

	public AccountInfo(double accountBalance, CustomerInfo customerInfo) {
		super();
		this.accountBalance = accountBalance;
		this.customerInfo = customerInfo;
	}

	public AccountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
