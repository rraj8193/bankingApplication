package com.project.banking;



import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.project.banking.admin.dao.ManageCustomerInfoImpl;
import com.project.banking.admin.daoInterface.IManageCustomer;
import com.project.banking.customer.entities.CustomerInfo;



@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
//		ApplicationContext context =  SpringApplication.run(BankingApplication.class, args);
//		
//		CustomerInfoRepository repo =  context.getBean(CustomerInfoRepository.class);
//		
//		CustomerInfo customer = new CustomerInfo("Rishav","Nawada","123445","765238293","bdsbsdn", true,new Date());
//		repo.save(customer);
//		
//		CustomerInfoServiceImpl service = context.getBean(CustomerInfoServiceImpl.class);
//		CustomerInfo info = service.getCustomerInfoById(1);
//		System.out.println(info.getCustomerName());
		
//		CustomerInfo customer = new CustomerInfo("Rishik","Nawada","123445","765238293","DWD8y3389", true,new Date());
//		IManageCustomer manageCustomer = context.getBean(ManageCustomerInfoImpl.class);
//		manageCustomer.addCustomerInfo(customer);
//		
//		List<CustomerInfo> list = manageCustomer.getAllCustomerInfo();
//		for(CustomerInfo c:list) {
//			System.out.println(c.getCustomerName());
//		}
//		
//		manageCustomer.updateCustomerInfo(customer, 52);
//		
//		manageCustomer.deleteCustomerInfo(1);
	}

}
