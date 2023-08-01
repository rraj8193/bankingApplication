package com.project.banking.customer.daoInterface;

import java.util.List;

import com.project.banking.customer.entities.AuthInfo;

public interface IAuthInfoService {
	
	public AuthInfo addAuthenticationInfo(AuthInfo authInfo);
	public AuthInfo getAuthenticationInfoByUsername(String Username);
	public List<AuthInfo> getAllAuthenticationInfo();
}
