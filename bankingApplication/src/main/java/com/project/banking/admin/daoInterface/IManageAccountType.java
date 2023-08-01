package com.project.banking.admin.daoInterface;

import java.util.List;

import com.project.banking.customer.entities.AccountType;

public interface IManageAccountType {
	
	public AccountType addAccountType(AccountType accountType);
	public List<AccountType> getAllAccountType();
	public AccountType getAccountTypeById(int accountTypeId);
	public AccountType updateAccountType(AccountType accountType,int accountTypeId);
	public void deleteAccountType(int accountTypeId);
}
