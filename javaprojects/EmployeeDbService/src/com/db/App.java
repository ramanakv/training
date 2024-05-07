package com.db;

import com.entity.Employee;
import com.service.*;

public class App {
	public static void main(String[] args) {

		EmployeeService ser = new EmployeeDbService();

		Employee x = ser.getEmployee(100);
		System.out.println(x);
		
		ser.saveEmployee(new Employee(999,"Hello",34000));
	}
}
