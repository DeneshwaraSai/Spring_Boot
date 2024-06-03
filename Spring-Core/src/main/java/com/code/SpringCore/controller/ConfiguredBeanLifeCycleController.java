package com.code.SpringCore.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.SpringCore.service.Coach;

@RestController
public class ConfiguredBeanLifeCycleController {
	
	private Coach myCoach;
	private Coach myCoach1;
	
	public ConfiguredBeanLifeCycleController(
			@Qualifier("swimCoach") Coach firstCoach,
			@Qualifier("swinCoachId") Coach secondCoach) {
		System.out.println("In BeanLifeCycleController constructor " + getClass().getSimpleName());
		myCoach = firstCoach;
		myCoach1 = secondCoach;
	}
	
	@GetMapping(path = "/swims")
	public String swins() {
		return myCoach1.getCoachMessage();
	}
}
