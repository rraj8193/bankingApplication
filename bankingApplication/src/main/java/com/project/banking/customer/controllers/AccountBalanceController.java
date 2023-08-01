package com.project.banking.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.banking.customer.dao.AccountInfoServiceImpl;
import com.project.banking.customer.entities.AccountInfo;

@RestController
@RequestMapping("/user")
public class AccountBalanceController {
	
	@Autowired
	AccountInfoServiceImpl accountInfoService;
	
	@GetMapping("/account-balance/{id}")
	public AccountInfo accountBalance(@PathVariable("id") int id) {
		return accountInfoService.getAccountBalance(id);
	}
}
