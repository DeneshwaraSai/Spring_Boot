package com.example.demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Account;

@Aspect
@Component
public class AspectOrderDemo {
	/*
	@Pointcut("execution(* com.example.demo.dao.*.*(..))")
	private void forDaoPackage() { }

	@Pointcut("execution(* com.example.demo.dao.*.get*(..))")
	private void getter() { 
		System.out.println("This is a advice for getter");
	}

	@Pointcut("execution(* com.example.demo.dao.*.set*(..))")
	private void setter() { 
		System.out.println("This is a advice for setter");
	}

	@Pointcut("forDaoPackage() && !(setter() || getter())")
	private void executeWithoutGettersAndSetters() {
		System.out.println("\n This is a advice for forDaoPackage() && !(setter() || getter())");
	}
	 */


	//	@Before("executeWithoutGettersAndSetters()")
	//	@Order(2)
	//	private void executeOrder2() {
	//		System.out.println("Execute only methods with order 2");
	//	}
	//	
	//	@Before("executeWithoutGettersAndSetters()")
	//	@Order(1)
	//	private void executeOrder() {
	//		System.out.println("Execute only methods with order 1");
	//	}

	/*
	@Before("com.example.demo.aspect.AspectOrderDemo.executeWithoutGettersAndSetters()")

	private void executeNoGetterAndSetter(JoinPoint joinPoint) {
		System.out.println("In joinpoint");

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println(signature);

		Object[] object = joinPoint.getArgs();
		for (Object obj : object)
			System.out.println("Arg : " + obj);
	}
	 */

	@AfterReturning(
			pointcut = "execution(* com.example.demo.dao.AccountDAO.findAccounts(..))", 
			returning = "result")
	private void afterReturningFindAccounts(JoinPoint joinPoint, List<Account> result) {
		String signature = joinPoint.getSignature().toShortString();
		System.out.println("Signature : " + signature);
		for (Account account: result) {
			account.setName(account.getName().toUpperCase());
		}
		System.out.println(result);
		System.out.println("====== Done with @AfterReturning advice Annotation ======");
	}

	@AfterThrowing(
			pointcut = "execution(* com.example.demo.dao.AccountDAO.findAccounts(..))",
			throwing = "exp")
	private void afterThrowingFindAccount(JoinPoint joinPoint, Throwable exp) {

		String signature = joinPoint.getSignature().toShortString();
		System.out.println("Signature : " + signature);

		System.out.println("The given message is : " + exp.getMessage());
		System.out.println("====== Done with @AfterThrowing advice Annotation ======");
	}

	@After("execution(* com.example.demo.dao.AccountDAO.findAccounts(..))") 
	public void afterFindAccounts(JoinPoint joinPoint) {
		String signature = joinPoint.getSignature().toShortString();
		System.out.println("Signature : " + signature);

		System.out.println("====== Done with @After advice Annotation ======");
	}

	@Around("execution(* com.example.demo.service.*.getFurtune(..))")
	public Object executeGetFurtureForAroundAdvice( 
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		try {
			String method = proceedingJoinPoint.getSignature().toLongString();
			System.out.println("Signature Method : " + method);

			long start = System.currentTimeMillis();

			Object result = proceedingJoinPoint.proceed();

			long end = System.currentTimeMillis();

			System.out.println("The time taken to execute is : " + (end - start)/1000.00);

			System.out.println("In Aspect : " + result);
			return result;
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("In AOP : Exception : " + e.getMessage());
			throw e;
		} 
	}
}
