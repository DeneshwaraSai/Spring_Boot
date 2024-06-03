package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeLeafDemoController {

	@GetMapping(path = "/hello")
	public String getModel(Model model) {
		model.addAttribute("theDate", new Date());
		return "helloWorld";
	}
}
