package trg.sf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // uses to create beans
@ComponentScan(basePackages = "trg")
public class AppConfig {

	@Bean("teacher1")
	public Teacher getTeacher1() {

		return new Teacher(111, "Sunitha");
	}

	@Bean("teacher2")
	public Teacher getTeacher2() {

		return new Teacher(222, "Akhilesh");
	}

	@Bean("std1")
	public Student getStudent1() {
		return new Student(11, "Sridhar");
	}
}
