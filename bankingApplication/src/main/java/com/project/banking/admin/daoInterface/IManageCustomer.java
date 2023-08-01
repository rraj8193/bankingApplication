package com.project.banking.admin.daoInterface;

import java.util.List;

import com.project.banking.customer.entities.CustomerInfo;

public interface IManageCustomer {
	public CustomerInfo addCustomerInfo(CustomerInfo customer);
	public CustomerInfo updateCustomerInfo(CustomerInfo customer, int customerId);
	public List<CustomerInfo> getAllCustomerInfo();
	public void deleteCustomerInfo(int id);
}
