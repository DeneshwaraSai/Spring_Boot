package com.code.SpringCore.service;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class BeanLifecCycleCoach implements Coach {
	
	public BeanLifecCycleCoach() {
		System.out.println("In constructor " + getClass().getSimpleName());
	}

	@Override
	public String getCoachMessage() {
		// TODO Auto-generated method stub
		return "We shall configure the Bean Lifecyle here.";
	}
	
	@PostConstruct
	private void startTheBean() {
		System.out.println("In checkTheBean method : " + getClass().getSimpleName());
	}
	
	@PreDestroy
	private void destroyTheBean() {
		System.out.println("In preDestroy method : " + getClass().getSimpleName());

	}

}
