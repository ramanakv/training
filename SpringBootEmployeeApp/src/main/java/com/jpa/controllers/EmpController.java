package com.jpa.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.jpa.entity.Employee;
import com.jpa.entity.Response;
import com.jpa.exceptions.EmployeeNotFoundException;
import com.jpa.exceptions.EmptyDataException;
import com.jpa.exceptions.InvalidUserException;

import com.jpa.service.EmployeeService;

@RestController
@RequestMapping("employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpController {

	@Autowired
	EmployeeService service;

	@GetMapping(value = "{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("eid") int empId) {
		Employee e = service.get(empId);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		List<Employee> list = service.getAll();
		return list;

	}

	@PostMapping
	public ResponseEntity<Response> saveEmployee(@Valid @RequestBody Employee e) {
		service.add(e);
		return new ResponseEntity(new Response("Employee Data successfully saved"), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Response> updatemployee(@Valid @RequestBody Employee e) {
		service.update(e);
		return new ResponseEntity(new Response("Employee data successfully updated"), HttpStatus.OK);

	}

	@DeleteMapping("{eid}")
	public ResponseEntity<Response> deleteEmployee(@PathVariable("eid") int id) {

		service.delete(id);
		return new ResponseEntity(new Response("Employee data with Id: " + id + " successfully deleted"),
				HttpStatus.OK);

	}

}
