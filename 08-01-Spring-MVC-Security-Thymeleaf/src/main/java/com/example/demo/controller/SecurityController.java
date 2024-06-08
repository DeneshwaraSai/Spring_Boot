package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping(path = "/")
	public String showHome() {
		return "home";
	}

	@GetMapping(path = "/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	@GetMapping(path = "/systems")
	public String showSystems() {
		return "systems";
	}
}
