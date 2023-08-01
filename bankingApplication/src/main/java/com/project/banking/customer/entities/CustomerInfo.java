package com.project.banking.customer.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "customer_info")
public class CustomerInfo {
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "address")
	private String Address;
	@Column(name = "mobile_no")
	private String mobNo;
	@Column(name = "aadhar_no")
	private String aadharNo;

	@Column(name = "pan_no")
	private String panNo;
	@Column(name = "is_active",columnDefinition="tinyint(1) default 1")
	private boolean isActive;
	@Column(name = "openingDate")
	@Temporal(TemporalType.DATE)
	private Date openingDate;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_type_id")
	@JsonBackReference
	AccountType accountType;
	
	@OneToOne(mappedBy = "customerInfo")
	@JsonManagedReference
	private AccountInfo accountInfo;
	
	
	@OneToMany(mappedBy = "customerInfo")
	@JsonManagedReference
	private List<TransactionInfo> transactionInfo;
	
	@OneToOne(mappedBy = "customerInfo")
	@JsonManagedReference
	private AuthInfo authInfo;
	

	



	public CustomerInfo(String customerName, String address, String mobNo, String aadharNo, String panNo,
			boolean isActive, Date openingDate, AccountType accountType, AccountInfo accountInfo,
			List<TransactionInfo> transactionInfo, AuthInfo authInfo) {
		super();
		this.customerName = customerName;
		Address = address;
		this.mobNo = mobNo;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		this.isActive = isActive;
		this.openingDate = openingDate;
		this.accountType = accountType;
		this.accountInfo = accountInfo;
		this.transactionInfo = transactionInfo;
		this.authInfo = authInfo;
	}



	public AuthInfo getAuthInfo() {
		return authInfo;
	}



	public void setAuthInfo(AuthInfo authInfo) {
		this.authInfo = authInfo;
	}



	public List<TransactionInfo> getTransactionInfo() {
		return transactionInfo;
	}



	public void setTransactionInfo(List<TransactionInfo> transactionInfo) {
		this.transactionInfo = transactionInfo;
	}



	public AccountType getAccountType() {
		return accountType;
	}
	
	

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public String getCustomerName() {
		return customerName;
	}
	

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	
	public int getAccountTypeId() {
        if (accountType != null) {
            return accountType.getAccountTypeId();
        }
        return -1; // Or any default value if the accountType is not set
    }
	

	

	

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}



	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}



	public CustomerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
