package com.trg.spring.springapp2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.currency.CurrencyConverter;
import com.trg.beans.Employee;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		CurrencyConverter converter = (CurrencyConverter) ctx.getBean("converter");

		double amount = converter.convert("JP", 500);
		System.out.println(amount);

		System.out.println("Employee Data");
		System.out.println("======================");

		Employee e1 = ctx.getBean("emp1", Employee.class);
		System.out.println(e1);
		Employee e2 = ctx.getBean("emp2", Employee.class);
		System.out.println(e2);
		Employee e3 = ctx.getBean("emp3", Employee.class);
		System.out.println(e3);
		
		ctx.close();
	}
}
