package com.trg;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmpService service;

	
	@RequestMapping
	public String getForm() {
		//ModelAndView mv = new ModelAndView("index");
		return "index";
	}
	
	@RequestMapping("get/{x}")
	public ModelAndView getEmployee(@PathVariable("x") int eid) {

		Employee e = service.getEmployee(eid);

		if (e == null) {
			return new ModelAndView("response", "message", "Employee with id " + eid + " does not exist");
		}

		ModelAndView mv = new ModelAndView("empdata");
		mv.addObject("emp", e);
		return mv;

	}

	@RequestMapping("delete/{x}")
	public ModelAndView deleteEmployee(@PathVariable("x") int eid) {

		boolean deleted = service.deleteEmployee(eid);

		if (deleted) {
			return new ModelAndView("response", "message", "Employee with id " + eid + " successfully deleted");
		}

		else {
			return new ModelAndView("response", "message", "Employee with id " + eid + " to delete does not exist");
		}

	}
	
	@RequestMapping("save")
	public ModelAndView saveEmployee(@RequestParam("empid")  int empId, 
			                         @RequestParam("name") String name, 
			                         @RequestParam("salary") float salary, 
			                         @RequestParam("dob") String dobStr) {
		
		LocalDate dob = LocalDate.parse(dobStr);
		Employee e = new Employee(empId,name,salary,dob);
		boolean saved = service.saveEmployee(e);
		
		if (saved) {
			return new ModelAndView("response", "message", "Employee with id " + empId + " successfully saved");
		}

		else {
			return new ModelAndView("response", "message", "Employee with id " + empId + " already exists");
		}
	}

}
