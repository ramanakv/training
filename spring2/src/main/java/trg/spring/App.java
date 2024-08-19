package trg.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(GenConfig.class);

		Department d1 = ctx.getBean("dept1",Department.class);

		System.out.println(d1);
		
		Department d2 = ctx.getBean("dept2", Department.class);

		System.out.println(d2);
		
		Employee e1 = ctx.getBean("emp1",Employee.class);
		
		System.out.println(e1);
	}
}
