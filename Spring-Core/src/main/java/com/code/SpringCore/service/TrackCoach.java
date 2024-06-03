package com.code.SpringCore.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach implements Coach {
	
	public TrackCoach() {
		System.out.println("In constructor " + getClass().getSimpleName());
	}
	
	@Override
	public String getCoachMessage() {
		// TODO Auto-generated method stub
		return "Track! Practice running for 15 mins everyday";
	}

}
