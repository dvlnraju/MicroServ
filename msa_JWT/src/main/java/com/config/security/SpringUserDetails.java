package com.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.config.persistance.UserInfoPersistace;

@Service
public class SpringUserDetails implements UserDetailsService{

	@Autowired 
	private UserInfoPersistace  userinfoPersist;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SpringUser user;
		try {
			user = new SpringUser(userinfoPersist.findByUserName(username));
		}catch(Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("No User with name : "+username);
		}
		return user;
	}

}
