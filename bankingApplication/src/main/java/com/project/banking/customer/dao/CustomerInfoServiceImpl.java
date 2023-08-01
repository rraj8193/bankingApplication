package com.project.banking.customer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.banking.customer.daoInterface.ICustomerInfoService;
import com.project.banking.customer.entities.CustomerInfo;
import com.project.banking.customer.repository.CustomerInfoRepository;

@Service
public class CustomerInfoServiceImpl implements ICustomerInfoService {
	
	@Autowired
	CustomerInfoRepository customerInfoRepository;

	@Override
	public CustomerInfo getCustomerInfoById(int id) {
		CustomerInfo customerInfo = customerInfoRepository.findById(id).get();
		return customerInfo;
	}

}
