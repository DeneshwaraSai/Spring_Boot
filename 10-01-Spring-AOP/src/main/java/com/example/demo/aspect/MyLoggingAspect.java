package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class MyLoggingAspect {
	
//	@Before("execution(public void addAccount())")
//	@Before("execution(public void ad*Account())") 
//	public void beforeAddAccountAdvice() {
//		System.out.println("Executing @Before before add account.");
//	}
	
//	@Before("execution(public void updateAccount())")
//	public void beforeUpdateAccountAdvice() {
//		System.out.println("Executing @Before before update account.");
//	}
	
//	@Before("execution(public void com.example.demo.dao.MembershipDAO.addAccount())") 
//	public void beforeAddAccountAdvice() {
//		System.out.println("Executing @Before Membership add account.");
//	}
	
//	@Before("execution(public void add*())") 
	public void beforeAddAdvice() {
		System.out.println("Executing @Before before add account.(add*)");
	}
	
//	@Before("execution(public * delete*())")
	public void beforedeleteAdvice() {
		System.out.println("Executing @Before before delete account.");
	}
}
