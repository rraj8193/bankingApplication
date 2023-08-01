package com.project.banking.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.banking.customer.entities.AuthInfo;
import com.project.banking.customer.repository.AuthInfoRepository;
@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	AuthInfoRepository authInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthInfo authInfo = authInfoRepository.findByUsername(username);
		User user = new User(authInfo.getUsername(), authInfo.getPassword(), getAuthority(authInfo));
		
		System.out.println("Pass "+user.getPassword());
		return user;
	}
	
	public Set<SimpleGrantedAuthority> getAuthority(AuthInfo authInfo) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+authInfo.getRole()));
		System.out.println("In Simple Granted Authority "+new SimpleGrantedAuthority(authInfo.getRole()));
		return authorities;
	}

}
