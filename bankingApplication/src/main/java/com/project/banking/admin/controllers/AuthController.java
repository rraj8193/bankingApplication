package com.project.banking.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.banking.customer.dao.AuthInfoServiceImpl;
import com.project.banking.customer.entities.AuthInfo;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthInfoServiceImpl authInfoService;
	
	
	
	@GetMapping("/register")
	public List<AuthInfo> getAllUser(){
		return authInfoService.getAllAuthenticationInfo();
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody AuthInfo authInfo){
		
		if(authInfoService.getAuthenticationInfoByUsername(authInfo.getUsername()) == null) {
			AuthInfo info = authInfoService.addAuthenticationInfo(authInfo);
			return ResponseEntity.ok("Authentication Successful");
		}
		else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Username Already exist");
		}
		
	}
}
