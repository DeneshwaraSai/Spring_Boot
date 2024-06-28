package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingMultiplePointCuts {
	
//	@Pointcut("execution(* com.example.demo.dao.*.*(..))")
//	private void forDaoPackage() { }
//	
//	@Pointcut("execution(* com.example.demo.dao.*.get*(..))")
//	private void getter() { 
//		System.out.println("This is a advice for setter");
//	}
//	
//	@Pointcut("execution(* com.example.demo.dao.*.set*(..))")
//	private void setter() { }
//	
//	@Before("setter()")
//	private void executeSetters() {
//		System.out.println("\n This is a advice for setter");
//	}
//	
//	@Before("getter()")
//	private void executeGetters() {
//		System.out.println("\n This is a advice for getter");
//	}
//	
//	@Before("forDaoPackage() && !(setter() || setter())")
//	private void execute() {
//		System.out.println("\n This is a advice for forDaoPackage() && !(setter() || setter())");
//	}
}
