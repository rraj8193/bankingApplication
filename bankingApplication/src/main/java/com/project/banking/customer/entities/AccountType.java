package com.project.banking.customer.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_type")
public class AccountType {
	@Id
	@Column(name = "account_type_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountTypeId;

	@Column(name = "account_type_name")
	private String accountTypeName;
	
	@OneToMany(mappedBy = "accountType",fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<CustomerInfo> cutomerInfoList;

	public AccountType() {
		super();

	}

	

	public AccountType(String accountTypeName, List<CustomerInfo> cutomerInfoList) {
		super();
		this.accountTypeName = accountTypeName;
		this.cutomerInfoList = cutomerInfoList;
	}



	public List<CustomerInfo> getCutomerInfoList() {
		return cutomerInfoList;
	}



	public void setCutomerInfoList(List<CustomerInfo> cutomerInfoList) {
		this.cutomerInfoList = cutomerInfoList;
	}



	public int getAccountTypeId() {
		return accountTypeId;
	}

	@Override
	public String toString() {
		return "AccountType [accountTypeName=" + accountTypeName + "]";
	}


	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

}
