package com.config.security;

import org.springframework.security.core.userdetails.User;

import com.config.bean.UserInfo;

public class SpringUser extends User {
	
	private static final long serialVersionUID = 1L;

	public SpringUser(UserInfo user) {
		super(user.getUsername(), user.getPassword(), user.getGrantedAuthorities());
	}

}
