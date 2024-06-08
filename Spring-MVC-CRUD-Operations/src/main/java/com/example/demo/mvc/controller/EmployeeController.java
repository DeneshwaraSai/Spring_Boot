package com.example.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trim = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trim);
	}

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping(path= "/employee/list")
	public String findAll(Model model) {
		
		List<Employee> employeeList = employeeService.findAll();
		
		model.addAttribute("employeeList", employeeList);
		
		return "employee-dashboard";
	}

	@GetMapping(path = "/employee/showForm")
	public String addEmployee(Model model) {

		model.addAttribute("employee", new Employee());

		return "employee-form.html";
	}	

	@PostMapping(path = "/employee/save")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, 
			BindingResult bindingResult) {

		System.out.println("Employee : " + employee.toString());
		System.out.println(bindingResult.hasErrors());
		if(bindingResult.hasErrors()) {
			return "employee-form";
		}
		
		employee = employeeService.save(employee);
		
		return "redirect:/employee/list";
	}

	@GetMapping(path = "/employee/update")
	public String update(@RequestParam("employeeId") Integer employeeId, Model model) {
		System.out.println(employeeId);
		Employee employee = employeeService.findById(employeeId);
		model.addAttribute("employee", employee);
		return "employee-form";
	}
	
	@GetMapping(path = "/employee/delete")
	public String delete(@RequestParam("employeeId") Integer employeeId) {
		
		System.out.println("Employee Id : " + employeeId);
		
		employeeService.deleteById(employeeId);
		
		return "redirect:/employee/list";
	}
}
