package com.code.SpringCore.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootBallCoach implements Coach {
	
	public FootBallCoach() {
		System.out.println("In constructor " + getClass().getSimpleName());
	}
	
	@Override
	public String getCoachMessage() {
		// TODO Auto-generated method stub
		return "Football! Practice goal Keeping for 15 mins everyday";
	}

}
