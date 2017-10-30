package com.artek.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.artek.model.User;
import com.artek.service.RegisterService;
import com.artek.validator.RegistrationValidator;

@Controller
public class RegistrationController {

	@Autowired RegisterService registerService;
	@Autowired RegistrationValidator registervalidator;
   
	
	@RequestMapping(value="/registration",method={RequestMethod.GET,RequestMethod.POST})// To show form
	public String register(@ModelAttribute("User")User user,BindingResult bindingResult,Map<String,User> map,Model model,HttpServletRequest request)
	{
		if(request.getMethod().equals("GET"))
		{
		map.put("User",new User());		
		}
		else
		{
			registervalidator.validate(user, bindingResult);
			if(!bindingResult.hasErrors())
			{
				registerService.registerUser(user);
				return "redirect:/login.do";
			}		
			//System.out.println(user.getFirstname()+user.getLastname()+user.getMobno()+user.getEmail()+user.getPassword()+user.getAddress());
		}
		return "registration";	}
}
