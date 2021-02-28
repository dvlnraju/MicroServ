package com.mtwo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtwo.entity.User;
import com.mtwo.persistance.UserPersistanceImpl;

@Service
public class UserService   
{    
	@Autowired    
	public UserPersistanceImpl userRepository;    

	public List<User> getAllUsers()  
	{    
		List<User> userRecords = new ArrayList<>();    
		userRepository.findAll().forEach(userRecords::add);    
		return userRecords;    
	}    

	public void addUser(User userRecord)  
	{    
		userRepository.save(userRecord);    
	}    
} 
