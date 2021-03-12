package com.OAuth.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

//@Getter
//@Setter
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name="login_info", schema = "db_local")
public class AuthUser {   
	@Id
	//@Column(name = "user_id")
	private int userid;    
	
	@Column(name = "username",nullable = false)
	private String username;    
	
	@Column(name= "email")
	private String email;  
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "password_b",nullable = false)
	private String passwordb;
	
	@Transient
	private Collection<GrantedAuthority> grantedAuthorities;
   
	public int getUserId() {
		return userid;
	}

	public void setUserId(int userId) {
		this.userid = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPasswordb() {
		return passwordb;
	}

	public void setPasswordb(String passwordb) {
		this.passwordb = passwordb;
	}

	public Collection<GrantedAuthority> getGrantedAuthorities() {
		grantedAuthorities = new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(Collection<GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}
	 
}
