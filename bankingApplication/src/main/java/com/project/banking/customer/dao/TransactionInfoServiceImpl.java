package com.project.banking.customer.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.banking.customer.daoInterface.ITransactionInfoService;
import com.project.banking.customer.entities.CustomerInfo;
import com.project.banking.customer.entities.TransactionInfo;
import com.project.banking.customer.repository.CustomerInfoRepository;
import com.project.banking.customer.repository.TransactionInfoRepository;

@Component
public class TransactionInfoServiceImpl implements ITransactionInfoService{
	
	@Autowired
	TransactionInfoRepository transactionInfoRepository;
	@Autowired
	AccountInfoServiceImpl accountInfoService;
	
	@Autowired
	CustomerInfoServiceImpl customerInfoService;

	@Override
	public List<TransactionInfo> getAllTransactionsInfo(int customerId) {
		return transactionInfoRepository.findAllTransactionsForACustomer(customerId).get();
	}

	@Override
	public TransactionInfo getTransactionInfoById(int customerId, int transactionId) {
		
		return transactionInfoRepository.findTransactionForACustomerById(customerId,transactionId).get();
	}

	@Override
	public TransactionInfo addTransactionInfo(TransactionInfo transaction) {
		TransactionInfo trans = transactionInfoRepository.save(transaction);
		
		updateBalance(transaction);
		
		CustomerInfo customer = customerInfoService.getCustomerInfoById(transaction.getTransactedWith());
		TransactionInfo otherParty = new TransactionInfo();
		otherParty.setTransactionType(!transaction.getTransactionType()); // Opposite transaction type
        otherParty.setTransactedWith(transaction.getCustomerInfo().getCustomerId()); // Swap transactedWith values
        otherParty.setTransactionAmount(transaction.getTransactionAmount());
        otherParty.setTransactionDate(transaction.getTransactionDate());
        otherParty.setStatus(transaction.getStatus());
        otherParty.setCustomerInfo(customer);
        transactionInfoRepository.save(otherParty);
        
        updateBalance(otherParty);
		
		return trans;
	}
	
	private void updateBalance(TransactionInfo transaction) {
		double transactionAmount = transaction.getTransactionAmount();
		int customerId = transaction.getCustomerInfo().getCustomerId();
		boolean type = transaction.getTransactionType();
		accountInfoService.updateAccountBalance(customerId,type,transactionAmount);
	}

}
