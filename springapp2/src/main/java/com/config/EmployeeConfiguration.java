package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.trg.beans.Department;
import com.trg.beans.Employee;

@Configuration
public class EmployeeConfiguration {

	@Bean(value = "emp1")
	@Scope("prototype")
	public Employee getEmp1() {
		Department d = new Department(10, "Sales");
		Employee e = new com.trg.beans.Employee(100, "Ramana", d, 34560);
		return e;
	}

	@Bean(value = "emp2")
	public Employee getEmp2() {
		Department d = new Department(20, "H R");
		Employee e = new com.trg.beans.Employee(200, "Suresh", d, 76560);
		return e;
	}

	@Scope("prototype")
	@Bean(value = "emp3")
	public Employee getEmp3() {
		Department d = new Department(10, "Sales");
		Employee e = new com.trg.beans.Employee(300, "Kishore", d, 220000);
		return e;
	}
	
	@Bean(value="dept1")
	public Department getDept() {
		return new Department(11,"Technical");
	}

}
