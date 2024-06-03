package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.StudentDetail;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

	@RequestMapping(path = "/showForm")
	public String showForm() {
		return "helloWorld-form";
	}

	@RequestMapping(path = "/processForm")
	public String processForm() {
		return "helloWorld-submit";
	}

	@RequestMapping(path = "/form")
	public String form1() {
		return "form1";
	}

	/* MODEL - 2 */
	@RequestMapping(path="/submitForm")
	public String formSubmit (@RequestParam("name") String name,
							@RequestParam("standard") String standard,
							@RequestParam("rollNo") String rollNo, Model model) {

		model.addAttribute("name", name);
		model.addAttribute("rollNo", rollNo);
		model.addAttribute("standard", standard);
		model.addAttribute("message", "My name is : " + name.toUpperCase());

		return "form1-submit";
	}


	/* MODEL - 1 */
	//	@RequestMapping(path = "/submitForm")
	//	public String formSubmit (HttpServletRequest request, Model model ) {
	//
	//		model.addAttribute("name", request.getParameter("name"));
	//		model.addAttribute("rollNo", request.getParameter\("rollNo"));
	//		model.addAttribute("standard", request.getParameter("standard"));
	//		model.addAttribute("message", "My name is : " + request.getParameter("name").toUpperCase());
	//
	//		return "form1-submit";
	//	}
}
