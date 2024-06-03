package com.example.demo.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trim = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trim);
	}

	@GetMapping(path = "/showCustomerForm")
	public String fillCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@PostMapping(path = "/processCustomer")
	public String processCustomer(@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult bindingResult) {

		System.out.println("The lastName is : |" + customer.getLastName() + "|");
		System.out.println("|" + customer.getCourseCode() + "|");
		if (bindingResult.hasErrors()) {
			return "customer-form";
		}
		return "customer-confirmation";
	}
}
