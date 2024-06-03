package com.code.SpringCore.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.SpringCore.service.Coach;

@RestController
public class SingletonCoachController {

	private Coach coach1;

	private Coach coach2;

	public SingletonCoachController(@Qualifier("cricketCoach") Coach firstCoach,
			@Qualifier("cricketCoach") Coach secondCoach) {
		coach1 = firstCoach;
		coach2 = secondCoach;
	}
	
	@GetMapping(path = "/checks") 
	private String checks() {
		return "Comparing if coach1 == coach2 is " + (coach1 == coach2);
	}
}
