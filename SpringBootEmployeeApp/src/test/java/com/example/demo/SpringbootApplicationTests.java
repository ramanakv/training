package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.dao.EmployeeDao;
import com.jpa.dao.EmployeeJpaDaoImpl;
import com.jpa.entity.Employee;
import com.jpa.repository.EmployeeRepository;
import com.jpa.service.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
class SpringbootApplicationTests {

	@Mock
	private EmployeeDao empDao;
	
	@InjectMocks
	private EmployeeServiceImpl empService;

	@Test
	void findEmployeeTest() {
		Employee e = new Employee(100, "Ramana", 22000, LocalDate.of(1998, 10, 21), null);
		
		when(empDao.getEmployee(100)).thenReturn(e);
		when(empDao.getEmployee(999)).thenReturn(null);

		Employee x = empService.get(100);
		assertEquals(x, e);
		
		Employee y = empService.get(999);
		assertNull(y);

	}
	

}
