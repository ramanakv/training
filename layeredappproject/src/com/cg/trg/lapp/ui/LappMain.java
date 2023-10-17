package com.cg.trg.lapp.ui;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

import com.cg.trg.lapp.dto.Employee;
import com.cg.trg.lapp.service.EmployeeService;
import com.cg.trg.lapp.service.EmployeeServiceImpl;

public class LappMain {
	
	public static void main(String args[]) {
		EmployeeService service = new EmployeeServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee Id");
		int eid=sc.nextInt();
		
		Employee e = service.getEmployee(eid);
		if(e==null)
			System.out.println("Employee with id "+eid+" not found");
		else
			System.out.println(e);
		
		boolean saved = service.addEmployee(new Employee(100,"Nidhi",LocalDate.of(1988, 1, 21),66000));
		if(saved) {
			System.out.println("Employee data saved");
			
		}
		else
			System.out.println("Employee with same id already exists");
		
		System.out.println("List of Employees");
		System.out.println("=================");
		
		Collection<Employee> allEmployees = service.getAllEmployees();
		
		for(Employee x : allEmployees)
			System.out.println(x);
	}

}
