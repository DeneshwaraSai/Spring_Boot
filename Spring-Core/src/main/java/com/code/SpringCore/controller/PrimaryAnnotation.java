package com.code.SpringCore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.SpringCore.service.Coach;

@RestController
public class PrimaryAnnotation {
	private Coach myCoach;

	@Autowired
	public PrimaryAnnotation(Coach theCoach) {
		myCoach = theCoach;
	}

	@GetMapping("/primaryWorkout")
	public String dailyWorkouts() {
		return myCoach.getCoachMessage();
	}
}
