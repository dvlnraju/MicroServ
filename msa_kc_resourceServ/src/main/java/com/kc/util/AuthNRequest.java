package com.kc.util;

public class AuthNRequest {
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthNRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//for serialization purposes
	public AuthNRequest() {
	}

}
