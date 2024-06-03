package com.code.SpringCore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	/* Injecting the application.properties here */
	@Value("${project.user.name}")
	private String username;

	@Value("${project.user.id}")
	private String userId;

	@GetMapping(path ="/username")
	private String getUsername() {
		return "The given username is " + username;
	}

	@GetMapping(path ="/userId")
	private String getUserpassword() {
		return "The given userId is " + userId;
	}

	@GetMapping(path = "")
	public String sayFirst() {
		return "Hello World";
	}

	@GetMapping(path = "/learning/{id}")
	public String learningById(@PathVariable(name = "id") String id) {
		System.out.println("\n In learning API. \n");
		return "Given Learning Id is : " + id;
	}
}

