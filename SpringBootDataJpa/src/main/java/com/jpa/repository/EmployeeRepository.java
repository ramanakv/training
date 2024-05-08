package com.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
  
	//To generate method based on field name
	List<Employee> findByName(String name);
	
	//List<Employee> list =  repo.findByName("Kishore");

	
	
	// to generate method based on query with parameter names
	@Query("select e from Employee e where e.salary > :sal and name = :nm")
	List<Employee> findBySalaryAndName( @Param("sal")  int salary,  @Param("nm")  String name);
	
	//List<Employee> list =  repo.getBySalaryAndName(10000,"Kishore");
	
	
	
	// to generate method based on query with positional parameters
	@Query("select e from Employee e where e.empId > ?1 and name = ?2")
	List<Employee> findByIdAndName(  int id, String name);
	
	//List<Employee> list =  repo.getByIdAndName(111,"Kishore");
}
