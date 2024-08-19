package trg.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "trg.spring")
public class GenConfig {
	
	@Bean(name="dept1")
	public Department getDept1() {
		return new Department(100, "Sales");
	}
	
	@Bean(name="dept2")
	public Department getDept2() {
		return new Department(200, "Technical");
	}

	@Bean(name="emp1")
	public Employee getEmp1(){
		return new Employee(111, "Suresh", 45000);
	}
	
	@Bean(name="emp2")
	public Employee getEmp2(){
		return new Employee(222, "Mahesh", 52000);
		
	}
}
