package com.code.SpringCore.service;

import org.springframework.stereotype.Component;

@Component
public class GamingCoach implements Coach {
	
	public GamingCoach() {
		System.out.println("In constructor " + getClass().getSimpleName());
	}
	
	@Override
	public String getCoachMessage() {
		// TODO Auto-generated method stub
		return "Gaming! Practice eye exercises for 15 mins everyday";
	}
}
