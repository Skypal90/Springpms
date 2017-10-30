package com.artek.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.artek.model.User;
import com.artek.repository.RegistrationRepository;

@Component
public class RegistrationValidator implements Validator {

	@Autowired
	RegistrationRepository repository;

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors error) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(error, "firstname", "error.firstname.empty");
		ValidationUtils.rejectIfEmpty(error, "lastname", "error.lastname.empty");
		ValidationUtils.rejectIfEmpty(error, "email", "error.email.empty");
		ValidationUtils.rejectIfEmpty(error, "password", "error.password.empty");
		ValidationUtils.rejectIfEmpty(error, "mobno", "error.mobileno.empty");

		/*---------------------------------------------*/
		
		if (!error.hasErrors()) {
			if (user.getFirstname().length() > 15) {
				error.rejectValue("firstname", "error.firstname.length");
			}

			if (user.getLastname().length() > 15) {
				error.rejectValue("lastname", "error.lastname.length");

			}

			if (user.getMobno().length() != 10) {
				error.rejectValue("mobno", "error.mobileno.length");
			} else {
				try {
					Long.parseLong(user.getMobno());
				} catch (NumberFormatException ne) {
					error.rejectValue("mobno", "error.mobileno.format");
				}
			}

			if (user.getPassword().length() < 8) {
				error.rejectValue("password", "error.password.length");
			} else {
				if (user.getPassword().contains("@") == false && user.getPassword().contains("!") == false
						&& user.getPassword().contains("#") == false && user.getPassword().contains("$") == false) {
					error.rejectValue("password", "error.password.format");
				}
			}

			if (user.getEmail().contains("@") && user.getEmail().contains(".") && user.getEmail().endsWith(".com")) {
				String email = user.getEmail();
				email = email.replace('.', '@');
				String[] str1 = email.split("@");
				for (String str : str1) {
					if (str.length() == 0) {
						error.rejectValue("email", "error.email.format");
						break;
					}
				}
			} else {
				error.rejectValue("email", "error.email.format");
			}
		}
		/*--------------*---------------------*/

		if (!error.hasErrors()) {
			if (repository.emailVerifyAndSubmit(user)) {
				error.rejectValue("email", "error.email.verify");
			}
		}

	}
}
