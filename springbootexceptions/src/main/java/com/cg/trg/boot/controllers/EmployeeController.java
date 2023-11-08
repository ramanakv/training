package com.cg.trg.boot.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.trg.boot.dto.AppResponse;
import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	@GetMapping(value = "{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("eid") int empId) {
		Employee e = service.getEmployee(empId);

		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<AppResponse> saveEmployee(@RequestBody Employee e) {
		service.addEmployee(e);
		AppResponse resp;

		resp = new AppResponse("SAVESUCCESS", "Employee with id " + e.getEmpid() + " successfully saved");
		return new ResponseEntity<AppResponse>(resp, HttpStatus.CREATED);

	}

	@PutMapping()
	public ResponseEntity<AppResponse> updateEmployee(@RequestBody Employee e) {
		service.updateEmployee(e);

		AppResponse resp = new AppResponse("UPDSUCCESS", "Employee with id " + e.getEmpid() + " successfully updated");
		return new ResponseEntity<AppResponse>(resp, HttpStatus.OK);
	}

	@DeleteMapping(value = "{eid}")
	public ResponseEntity<AppResponse> deleteEmployee(@PathVariable("eid") int empId) {
		service.deleteEmployee(empId);

		AppResponse resp = new AppResponse("DELSUCCESS", "Employee with id " + empId + " successfully deleted");
		return new ResponseEntity<AppResponse>(resp, HttpStatus.OK);

	}
}
