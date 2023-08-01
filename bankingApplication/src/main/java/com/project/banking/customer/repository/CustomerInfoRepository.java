package com.project.banking.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.banking.customer.entities.CustomerInfo;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Integer>{
	
	@Query("SELECT c FROM CustomerInfo c")
	public List<CustomerInfo> findAllCustomer();
}
