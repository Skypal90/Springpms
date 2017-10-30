package com.artek.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.artek.model.User;
import com.artek.service.RegisterService;
import com.artek.webservices.model.Employee;

@Controller
public class EmployeeController {
	@Autowired
	RegisterService registerService;

	@RequestMapping(value = "/employee/{id}/{name}", method = RequestMethod.GET, produces = "application/json", headers = "accept=Application/json")
	public @ResponseBody ModelAndView getEmployee(@PathVariable("id") String id, @PathVariable("name") String name) {

		System.out.println(("Inside controller"));
		System.out.println(name);
		Employee emp = new Employee();
		emp.setE_id(Integer.valueOf(id));
		emp.setE_fname(name);
		emp.setE_lname("Jaiswal");
		emp.setE_salary(30000);
		// return emp;
		return new ModelAndView("webservice_1", "employee", emp);
	}

	@RequestMapping(value = "/employeepost", method = RequestMethod.POST, produces = "application/json", headers = "accept=Application/json")
	public @ResponseBody void saveInfo(@RequestBody User user) {

		registerService.registerUser(user);
		// List list=project.getProjectInfo(id);
	}
}
