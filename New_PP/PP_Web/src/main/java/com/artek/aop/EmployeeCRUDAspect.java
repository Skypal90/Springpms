/*package com.artek.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeCRUDAspect {

	@Before("execution(* EmployeeManager.*(..))")
	public void logBeforeV2(JoinPoint joinpoint)
	{
		System.out.println("EmployeeCRUDAspect.logBeforeV2() : " +joinpoint.getSignature().getName());
	}
	
	@Before("execution(* EmployeeManager.getEmployeeById(..))")
	public void logBeforeV1(JoinPoint joinpoint)
	{
		System.out.println("EmployeeCRUDAspect.logBeforeV1() : "+ joinpoint.getSignature().getName());
	}
	
	
}
*/