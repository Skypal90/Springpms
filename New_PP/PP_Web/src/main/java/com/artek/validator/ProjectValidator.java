package com.artek.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.artek.model.ProjectDTO;
import com.artek.model.User;

@Component
public class ProjectValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return ProjectDTO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ProjectDTO projectDTO=(ProjectDTO)target;
		ValidationUtils.rejectIfEmpty(errors,"pname","error.projectname.empty");
		ValidationUtils.rejectIfEmpty(errors,"clientname","error.clientname.empty");
		ValidationUtils.rejectIfEmpty(errors,"startdate","error.startdate.empty");
		ValidationUtils.rejectIfEmpty(errors,"enddate","error.enddate.empty");		
	}
}
