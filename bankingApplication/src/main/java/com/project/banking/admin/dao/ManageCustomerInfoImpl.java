package com.project.banking.admin.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.banking.admin.daoInterface.IManageCustomer;
import com.project.banking.customer.daoInterface.ICustomerInfoService;
import com.project.banking.customer.entities.CustomerInfo;
import com.project.banking.customer.repository.CustomerInfoRepository;

@Component
public class ManageCustomerInfoImpl implements IManageCustomer,ICustomerInfoService {
	
	@Autowired
	CustomerInfoRepository customerInfoRepository;

	@Override
	public CustomerInfo addCustomerInfo(CustomerInfo customer) {
		customer =  customerInfoRepository.save(customer);
		return customer;
	}

	@Override
	public CustomerInfo updateCustomerInfo(CustomerInfo customer,int customerId) {
		CustomerInfo customerInfo = customerInfoRepository.findById(customerId).get();
		
		if(Objects.nonNull(customer.getCustomerName())) {
			customerInfo.setCustomerName(customer.getCustomerName());
		}
		if(Objects.nonNull(customer.getAddress())) {
			customerInfo.setAddress(customer.getAddress());
		}
		if(Objects.nonNull(customer.getMobNo())) {
			customerInfo.setMobNo(customer.getMobNo());
		}
		
		
		return customerInfoRepository.save(customerInfo);
	}

	@Override
	public List<CustomerInfo> getAllCustomerInfo() {
		List<CustomerInfo> customerInfoList = customerInfoRepository.findAll();
		return customerInfoList;
	}

	@Override
	public void deleteCustomerInfo(int id) {
		customerInfoRepository.deleteById(id);
		
	}

	@Override
	public CustomerInfo getCustomerInfoById(int id) {
		
		CustomerInfo customerInfo = customerInfoRepository.findById(id).get();
		System.out.println(customerInfo.getAccountType().getAccountTypeId());
		return customerInfo;
	}

}
