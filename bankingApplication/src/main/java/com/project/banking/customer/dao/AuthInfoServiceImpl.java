package com.project.banking.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.banking.customer.daoInterface.IAuthInfoService;
import com.project.banking.customer.entities.AuthInfo;
import com.project.banking.customer.repository.AuthInfoRepository;

@Component
public class AuthInfoServiceImpl implements IAuthInfoService{
	
	@Autowired
	AuthInfoRepository authInfoRepository;

	@Override
	public AuthInfo addAuthenticationInfo(AuthInfo authInfo) {
		
//		String generatedId = authInfo.getUsername();
//		authInfo.setUsername(generatedId);
		
		return authInfoRepository.save(authInfo);
	}

	@Override
	public AuthInfo getAuthenticationInfoByUsername(String username) {
		
		AuthInfo authInfo = authInfoRepository.findByUsername(username);
		return authInfo;
	}

	@Override
	public List<AuthInfo> getAllAuthenticationInfo() {
		List<AuthInfo> authInfoList = authInfoRepository.findAll();
		return authInfoList;
	}

}
