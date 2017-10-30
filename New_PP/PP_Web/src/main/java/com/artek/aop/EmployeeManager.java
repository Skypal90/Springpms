package com.artek.aop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.artek.model.EmployeeDTO;

@Component
public class EmployeeManager {
public EmployeeDTO getEmployeeById(Integer employeeid)
{
	System.out.println("method getEmployeeById() Called");
	return new EmployeeDTO();
}

public List<EmployeeDTO> getAllEmployee ()
{
	System.out.println("method getAllEmployee() called");
	return new ArrayList<EmployeeDTO>();
}

public void createEmployee()
{
	System.out.println("method createEmployee() called");
}

public void deleteEmployee()
{
	System.out.println("method deleteEmployee() called");
}

public void updateEmployee()
{
	System.out.println("method updateEmployee() called");
}
}
