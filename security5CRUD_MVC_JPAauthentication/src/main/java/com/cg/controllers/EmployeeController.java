package com.cg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.dto.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

@Controller
public class EmployeeController {

	Map<Integer, Employee> data;

	public EmployeeController() {
		data = new HashMap<Integer, Employee>();

		data.put(100, new Employee(100, "Abhishek", 23000));
		data.put(200, new Employee(200, "Birbal", 34000));
		data.put(300, new Employee(300, "Charlie", 13000));
		data.put(400, new Employee(400, "Deepak", 14000));
	}

	@GetMapping("/home")
	public String welcome() {

		return "welcome";
	}

	@GetMapping("/getById/{eid}")
	public ModelAndView getEmployee(@PathVariable("eid") int empid) {
		Employee e = data.get(empid);
		if (e != null) {
			return new ModelAndView("empdetails", "emp", e);
		} else {
			return new ModelAndView("response", "msg", "Employee with id " + empid + " not found");
		}
	}

	@GetMapping("getAll")
	public ModelAndView getAllEmployee() {
		Collection<Employee> allemployees = data.values();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("emplist");
		mv.addObject("emps", allemployees);
		mv.addObject("message", "Thank You");
		return mv;
	}

	@GetMapping("create")
	public ModelAndView showForm() {
		Employee e = new Employee();
		return new ModelAndView("empform", "employee", e);

	}

	@PostMapping("create")
	public ModelAndView saveData(@ModelAttribute("employee") Employee e) {

		if (data.containsKey(e.getEmpId())) {
			return new ModelAndView("response", "msg", "Employee with id " + e.getEmpId() + " already exists");
		} else {
			data.put(e.getEmpId(), e);
			return new ModelAndView("response", "msg", "Employee with id " + e.getEmpId() + " successfully saved");
		}
	}
}
