package com.project.banking.customer.daoInterface;

import java.util.List;

import com.project.banking.customer.entities.TransactionInfo;

public interface ITransactionInfoService {
	public List<TransactionInfo> getAllTransactionsInfo(int customerId);
	public TransactionInfo getTransactionInfoById(int customerId, int transactionId);
	public TransactionInfo addTransactionInfo(TransactionInfo transaction);
	
}
