package com.artek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.artek.model.AddressDTO;
import com.artek.model.UserDTO1;

@Controller
public class UserAddress {

	@RequestMapping(value="/useraddress" , method= {RequestMethod.GET,RequestMethod.POST})
	public String userInfo(@ModelAttribute("useradd") UserDTO1 user,ModelMap map,HttpServletRequest request)	
	{
		if(request.getMethod().equals("GET"))
		{
			System.out.println("inside get");
		map.put("useradd", new UserDTO1());
		return "useraddress";
		}
		else
		{
			System.out.println("hello");
			List<AddressDTO> list=user.getAdd();
			System.out.println(list);
			for(AddressDTO addressDTO:list)
			{
				System.out.println("inside post");
				System.out.println(list.get(3));
				System.out.println(addressDTO.getCity());
			}
			return "useraddress";
		}
	}
	
}
