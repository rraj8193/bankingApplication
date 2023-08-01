package com.project.banking.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.banking.admin.dao.ManageCustomerInfoImpl;
import com.project.banking.customer.entities.CustomerInfo;

@RestController
@RequestMapping("/user")
public class CustomerInfoController {

	@Autowired
	ManageCustomerInfoImpl manageCustomerRepository;
	@GetMapping("/user/{id}")
	public CustomerInfo getCustomerInfo(@PathVariable("id") int id) {
		CustomerInfo customer = manageCustomerRepository.getCustomerInfoById(id);
		return customer;
	}
}
