package com.sanskar.entity;

public class LoginDetails {
	
	private String username;
	private String password;
	
	public LoginDetails() {}

	public LoginDetails(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "LoginDetails [username=" + username + ", password=" + password + "]";
	}	
}
