package com.project.banking.customer.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "auth_info")
public class AuthInfo {
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name="email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role = "USER";
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "customer_info_id")
	private CustomerInfo customerInfo;

	public AuthInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public AuthInfo(String username, String email, String password, CustomerInfo customerInfo) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = "ROLE_USER";
		this.customerInfo = customerInfo;
	}

}
