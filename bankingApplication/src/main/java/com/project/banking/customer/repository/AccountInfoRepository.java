package com.project.banking.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.banking.customer.entities.AccountInfo;

public interface AccountInfoRepository extends JpaRepository<AccountInfo, Integer> {
	
	@Query("SELECT ai FROM AccountInfo ai WHERE ai.customerInfo.customerId =:id ORDER BY ai.accountInfoId DESC")
    Optional<AccountInfo> findLatestBalance(@Param("id") int id);
}
