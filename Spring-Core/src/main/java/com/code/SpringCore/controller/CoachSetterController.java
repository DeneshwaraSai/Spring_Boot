package com.code.SpringCore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.SpringCore.service.Coach;

@RestController
public class CoachSetterController {

	private Coach myCoach;

	@Autowired
	public void setMyCoach(@Qualifier("footBallCoach") Coach myCoach) {
		this.myCoach = myCoach;
	}

	@GetMapping("/workouts/game")
	public String dailyWorkouts() {
		return myCoach.getCoachMessage();
	}

}
