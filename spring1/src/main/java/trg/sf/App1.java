package trg.sf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import trg.msg.MessageBuilder;

public class App1 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Teacher t1 = ctx.getBean("teacher1", Teacher.class);
		
		System.out.println(t1);
		
		Student s = ctx.getBean("std1", Student.class);
		
		System.out.println(s);
		
		CurrencyRateProvider crp = ctx.getBean("provider", CurrencyRateProvider.class);
		
		System.out.println(crp.getRate("USD"));
		
		MessageBuilder mb = ctx.getBean("mb",MessageBuilder.class);
		
		System.out.println(mb.sayHello());

	}

}
