package com.artek.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.artek.model.User;
import com.artek.validator.LoginValidator;

@Controller
public class LoginController {

	@Autowired
	public LoginValidator loginValidator;

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String showLogin(@ModelAttribute("User") User user, BindingResult bindingResult, Map<String, User> map,
			HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			map.put("User", new User());
			System.out.println("HELLO");

		} else {
			loginValidator.validate(user, bindingResult);
			if (!bindingResult.hasErrors()) {
				return "redirect:/projectmanagement.do";
			}
		}
		return "login";
	}

}

