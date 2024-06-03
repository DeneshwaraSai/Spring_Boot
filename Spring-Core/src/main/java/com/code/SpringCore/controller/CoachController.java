package com.code.SpringCore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.SpringCore.service.Coach;

@RestController
public class CoachController {

	private Coach myCoach;

	@Autowired
	public CoachController(@Qualifier("cricketCoach") Coach theCoach) {
		System.out.println("In constructor " + getClass().getSimpleName());
		myCoach = theCoach;
	}

	@GetMapping("/workouts")
	public String dailyWorkouts() {
		return myCoach.getCoachMessage();
	}
}
