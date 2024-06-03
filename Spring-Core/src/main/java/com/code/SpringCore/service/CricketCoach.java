package com.code.SpringCore.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("In constructor " + getClass().getSimpleName());
	}
	
	@Override
	public String getCoachMessage() {
		// TODO Auto-generated method stub
		return "Cricket! Practice fast bowling for 15 mins everyday";
	}
	
}
