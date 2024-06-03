package com.code.SpringCore.service;

public class SwimCoach implements Coach{
	
	public SwimCoach() {
		System.out.println("In constructor " + getClass().getSimpleName());
	}
	
	@Override
	public String getCoachMessage() {
		// TODO Auto-generated method stub
		return "Swim! Practice swimming for 30 mins everyday";
	}
}
