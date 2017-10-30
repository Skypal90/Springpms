package com.artek.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.artek.model.User;
import com.artek.repository.LoginRepository;

@Component
public class LoginValidator implements Validator {

	@Autowired
	LoginRepository loginRepository;

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors error) {
		ValidationUtils.rejectIfEmpty(error, "email", "error.email.empty");
		ValidationUtils.rejectIfEmpty(error, "password", "error.password.empty");

		if (!error.hasErrors()) {
			if (loginRepository.userSignIn((User) target)) {
                error.rejectValue("email", "error.email&password.match");
                error.rejectValue("password", "error.email&password.match");
			}
		}
	}

}
