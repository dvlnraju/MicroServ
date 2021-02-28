package com.config.util;

public class AuthNResponse {
	
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthNResponse(String jwt) {
		this.jwt = jwt;
	}
	
	

}
