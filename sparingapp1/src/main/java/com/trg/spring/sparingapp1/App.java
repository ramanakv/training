package com.trg.spring.sparingapp1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Car;
import com.trg.beans.Department;
import com.trg.beans.Employee;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		Car c= (Car) ctx.getBean("car");

		System.out.println(c);

		ctx.close();


	}
}
