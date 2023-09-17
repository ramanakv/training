package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
