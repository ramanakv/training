package trg.spring.spring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import trg.spring.Employee;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("emp.xml");

		Employee e = ctx.getBean("emp3",Employee.class);
		
		System.out.println(e);
	}
}
