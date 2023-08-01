package com.project.banking.customer.daoInterface;

import com.project.banking.customer.entities.AccountInfo;

public interface IAccountInfoService {
	
	public AccountInfo getAccountBalance(int id);
	public void updateAccountBalance(int customerId,boolean type,double transactionAmount);

}
