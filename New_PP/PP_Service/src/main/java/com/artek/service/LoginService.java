package com.artek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artek.model.User;
import com.artek.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	public LoginRepository loginrepository; 
	
public User validateUser(User user)
{
	return user;
}
}
