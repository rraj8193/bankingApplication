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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.banking.admin.dao.ManageCustomerInfoImpl;
import com.project.banking.customer.entities.CustomerInfo;

@RestController
@RequestMapping("/admin")
public class HomeController {
	
	@Autowired
	ManageCustomerInfoImpl manageCustomerRepository;
	
	@GetMapping("/manage-customer/{id}")
	public CustomerInfo getCustomerInfo(@PathVariable("id") int id) {
		CustomerInfo customer = manageCustomerRepository.getCustomerInfoById(id);
		return customer;
	}
	
	@GetMapping("/manage-customer")
	public List<CustomerInfo> getAllCustomerInfo(){
		System.out.println("Request Came.........");
		return manageCustomerRepository.getAllCustomerInfo();
	}
	
	@PostMapping("/manage-customer")
	public CustomerInfo addCustomer(@RequestBody CustomerInfo customer) {
		return manageCustomerRepository.addCustomerInfo(customer);
	}
	
	@PutMapping("/manage-customer")
	public CustomerInfo updateCustomer(@RequestBody CustomerInfo customer) {
		return manageCustomerRepository.updateCustomerInfo(customer, customer.getCustomerId());
	}
	
	@DeleteMapping("/manage-customer/{id}")
	@ResponseBody
	public String deleteCustomer(@PathVariable("id") int id) {
		manageCustomerRepository.deleteCustomerInfo(id);
		return "Customer Deleted SuccessFully";
	}

}
