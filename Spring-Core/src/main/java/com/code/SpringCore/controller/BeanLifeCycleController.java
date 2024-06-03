package com.code.SpringCore.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.SpringCore.service.Coach;

@RestController
public class BeanLifeCycleController {
	
	private Coach myCoach;
	
	public BeanLifeCycleController(@Qualifier("beanLifecCycleCoach") Coach coach) {
		System.out.println("In BeanLifeCycleController constructor " + getClass().getSimpleName());
		myCoach = coach;
	}
	
	@GetMapping(path="/beanLifeCycleCheck")
	public String beanLifeCycleCheck() {
		return "In beanLifeCycleCheck";
	}
}
