package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping(path = "/showMyLoginPage")
	public String showMyLoginPage() {
		return "plain-login";
	}
	
	@GetMapping(path = "/access-denied")
	public String getAccessDeniedPage() {
		return "access-denied";
	}
}
