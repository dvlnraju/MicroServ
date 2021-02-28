package com.mone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;  
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;  

@Entity 
@Table(name="User_Details", schema = "db_local")
public class User  
{   
	@Id    
	private int id;    
	
	@Column(name = "Name",nullable = false)
	private String name;    
	
	@Column(name= "e_mail",nullable = false)
	private String email;  
	
   
	public int getId()   
	{    
		return id;    
	}    
	
	public void setId(int id)   
	{    
		this.id = id;    
	}    
	
	public String getName()   
	{    
		return name;    
	}    
	
	public void setName(String name)   
	{    
		this.name = name;    
	}    
	
	public String getEmail()   
	{    
		return email;    
	}    
	
	public void setEmail(String email)   
	{  
		this.email = email;    
	}   
	
	@Transient
	private String userDetails;


	public String getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}
	
	
	
}    
