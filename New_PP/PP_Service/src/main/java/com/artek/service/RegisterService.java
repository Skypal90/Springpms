package com.artek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artek.model.User;
import com.artek.repository.RegistrationRepository;

@Service
public class RegisterService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	
	public void registerUser(User user)
	{
		registrationRepository.register(user);
	}
}
