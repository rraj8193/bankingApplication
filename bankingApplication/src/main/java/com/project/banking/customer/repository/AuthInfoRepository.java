package com.project.banking.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.banking.customer.entities.AuthInfo;

public interface AuthInfoRepository extends JpaRepository<AuthInfo, String>{
	public AuthInfo findByUsername(String username);
}
