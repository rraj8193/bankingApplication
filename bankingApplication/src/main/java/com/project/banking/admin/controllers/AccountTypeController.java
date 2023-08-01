package com.project.banking.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.banking.admin.dao.ManageAccountTypeImpl;
import com.project.banking.customer.entities.AccountType;

@RestController
@RequestMapping("/admin")
public class AccountTypeController {
	
	@Autowired
	ManageAccountTypeImpl manageAccountType;
	
	@GetMapping("/accountType")
	public List<AccountType> getAllAccountType(){
		return manageAccountType.getAllAccountType();
	}
	
	
	@GetMapping("/accountType/{id}")
	public AccountType getAccountType(@PathVariable("id") int id) {
		return manageAccountType.getAccountTypeById(id);
	}
	
	@PostMapping("/accountType")
	public AccountType addAccountType(@RequestBody AccountType accountType) {
		return manageAccountType.addAccountType(accountType);
	}
	
	@PutMapping("/accountType")
	public AccountType updateAccountType(@RequestBody AccountType accountType) {
		return manageAccountType.updateAccountType(accountType, accountType.getAccountTypeId());
	}
	
	@DeleteMapping("/accountType/{id}")
	public String deleteAccount(@PathVariable("id") int id) {
		manageAccountType.deleteAccountType(id);
		return "Account Type Deleted Successfully";
	}

}
