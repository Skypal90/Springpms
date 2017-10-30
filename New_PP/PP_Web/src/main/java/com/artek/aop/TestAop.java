package com.artek.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext01.xml");

		EmployeeManager manager = context.getBean(EmployeeManager.class);
		manager.getEmployeeById(1);
	}
}
