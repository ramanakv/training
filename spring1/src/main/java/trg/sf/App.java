package trg.sf;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");   // creating container
		
		Employee e1 = ctx.getBean("emp2", Employee.class);
		
		System.out.println(e1);
		
 	}
}

