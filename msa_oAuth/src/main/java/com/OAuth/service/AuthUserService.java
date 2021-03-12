package com.OAuth.service;

import com.OAuth.bean.AuthUser;
import com.OAuth.controller.UserDto;
import com.OAuth.persistance.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class AuthUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthUser register(@RequestBody UserDto userDto) {
       // AuthUser authUser = new ObjectMapper().convertValue(userDto, AuthUser.class);
    	AuthUser authUser = new AuthUser();
    	authUser.setUsername(userDto.getUserName());
    	authUser.setPassword(userDto.getPassword());
        authUser.setPasswordb(passwordEncoder.encode(userDto.getPassword()));
		/*
		 * List<SimpleGrantedAuthority> grantedAuthorities = new List<>();
		 * grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		 * authUser.setGrantedAuthorities(grantedAuthorities);
		 */
        Optional<AuthUser> optUser = userRepository.findByUsername(userDto.getUserName());
        if (!optUser.isPresent()) {
            return userRepository.save(authUser);
        }
        throw new RuntimeException("User already exist");
    }
}
