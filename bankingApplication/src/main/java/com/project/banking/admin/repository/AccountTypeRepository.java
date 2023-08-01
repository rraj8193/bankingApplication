package com.project.banking.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.banking.customer.entities.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
	
}
