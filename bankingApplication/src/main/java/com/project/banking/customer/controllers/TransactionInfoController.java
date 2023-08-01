package com.project.banking.customer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.banking.customer.dao.TransactionInfoServiceImpl;
import com.project.banking.customer.entities.TransactionInfo;

@RestController
@RequestMapping("/user")
public class TransactionInfoController {
	
	@Autowired
	TransactionInfoServiceImpl transactionService;

	@GetMapping("/transaction-info/{customer-id}/all")
	public List<TransactionInfo> getTransactions(@PathVariable("customer-id") int customerId) {
		return transactionService.getAllTransactionsInfo(customerId);
	}
	
	@GetMapping("/transaction-info/{customer-id}/{transaction-id}")
	public TransactionInfo getTransactionById(@PathVariable("customer-id") int customerId, @PathVariable("transaction-id") int transactionId) {
		return transactionService.getTransactionInfoById(customerId,transactionId);
	}
	
	@PostMapping("/transaction-info")
	public TransactionInfo addTransaction(@RequestBody TransactionInfo transactionInfo) {
		return transactionService.addTransactionInfo(transactionInfo);
	}
	
}
