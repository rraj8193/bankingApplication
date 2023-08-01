package com.project.banking.admin.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.banking.admin.daoInterface.IManageAccountType;
import com.project.banking.admin.repository.AccountTypeRepository;
import com.project.banking.customer.entities.AccountType;


@Component
public class ManageAccountTypeImpl implements IManageAccountType {
	
	@Autowired
	AccountTypeRepository repository;

	@Override
	public AccountType addAccountType(AccountType accountType) {
		AccountType type = repository.save(accountType);
		return type;
	}

	@Override
	public List<AccountType> getAllAccountType() {
		List<AccountType> list = repository.findAll();
		return list;
	}

	@Override
	public AccountType getAccountTypeById(int accountTypeId) {
		AccountType type = repository.findById(accountTypeId).get();
		return type;
	}

	@Override
	public AccountType updateAccountType(AccountType accountType, int accountTypeId) {
		AccountType type = repository.findById(accountTypeId).get();
		if(Objects.nonNull(accountType.getAccountTypeName())) {
			type.setAccountTypeName(accountType.getAccountTypeName());
		}
		
		return repository.save(type);
	}

	@Override
	public void deleteAccountType(int accountTypeId) {
		repository.deleteById(accountTypeId);
		
	}

}
