package com.project.banking.customer.entities;

public class JwtResponse {
	
	private JwtRequest jwtRequest;
	private String token;
	public JwtRequest getJwtRequest() {
		return jwtRequest;
	}
	public void setJwtRequest(JwtRequest jwtRequest) {
		this.jwtRequest = jwtRequest;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public JwtResponse(JwtRequest jwtRequest, String token) {
		super();
		this.jwtRequest = jwtRequest;
		this.token = token;
	}
	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
