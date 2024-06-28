package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingPointCutAspect {
	
//	@Pointcut("execution(* com.example.demo.*.*(..))")
	/* 
	 * This pointcut is used to execute first and then the respective methods execute later.
	 * Next time this method will not executed.
	 */
	public void forDaoPackage() {
		System.out.println("Started");
	}
	
//	@Before("forDaoPackage()")
//	@Before("execution(* com.example.demo.*.*(..))")
	public void executeOnlyDAOPackage() {
		System.out.println("Executing before advice on method.");
	}
}
