package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.StudentDetail;

@Controller
public class StudentDetailController {
	
	@Value("${countries}")
	private List<String> countriesList;
	
	@Value("${listOfSkills}")
	private List<String> listOfSkills;
	
	@Value("${favouriteSystems}")
	private List<String> favouriteSystems;
	
	@GetMapping(path = "/showStudentForm")
	public String showForm(Model model) {
		StudentDetail student = new StudentDetail();
//		student.setFirstName("dfbhdg");
		model.addAttribute("student", student);
		model.addAttribute("countries", countriesList);
		model.addAttribute("listOfSkills", listOfSkills);
		model.addAttribute("favouriteOS", favouriteSystems);
		
		return "student-form";
	}
	
	@PostMapping(path = "/processStudentForm")
	public String processStudentForm(@ModelAttribute("student") StudentDetail theStudent) {
		System.out.println("The firstname of the student is " + theStudent.getFirstName() + " and the lastname is " + theStudent.getLastName() + " and from " + theStudent.getCountry() + " country.");
		return "student-confirmation";
	}
	
}
