package com.project.banking.customer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.banking.customer.daoInterface.IAccountInfoService;
import com.project.banking.customer.entities.AccountInfo;
import com.project.banking.customer.repository.AccountInfoRepository;

@Component
public class AccountInfoServiceImpl implements IAccountInfoService{
	
	@Autowired
	AccountInfoRepository accountInfoRepository;

	@Override
	public AccountInfo getAccountBalance(int id) {
		return this.accountInfoRepository.findLatestBalance(id).get();
	}

	@Override
	public void updateAccountBalance(int customerId,boolean type,double transactionAmount) {
		AccountInfo accountInfo = getAccountBalance(customerId);
		double accountBalance = accountInfo.getAccountBalance();
		accountBalance = type ? accountBalance+transactionAmount : accountBalance-transactionAmount;
		accountInfo.setAccountBalance(accountBalance);
		accountInfoRepository.save(accountInfo);
		
	}
	
}
