package com.project.banking.customer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_auth")
public class CustomerAuth {
	@Id
	@Column(name = "customer_auth_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerAuthId;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;

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

	protected CustomerAuth(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
