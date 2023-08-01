package com.project.banking.customer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.project.banking.customer.entities.TransactionInfo;

public interface TransactionInfoRepository extends JpaRepository<TransactionInfo, Integer>{
	
	@Query("Select ti from TransactionInfo ti where ti.customerInfo.customerId =:customerId")
	Optional<List<TransactionInfo>> findAllTransactionsForACustomer(@Param("customerId") int customerId);
	@Query("Select ti from TransactionInfo ti where ti.customerInfo.customerId =:customerId and ti.transactionId =:transactionId")
	Optional<TransactionInfo> findTransactionForACustomerById(@Param("customerId") int customerId,@Param("transactionId") int transactionId);

}
