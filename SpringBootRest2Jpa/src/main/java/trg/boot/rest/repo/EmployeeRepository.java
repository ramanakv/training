package trg.boot.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import trg.boot.rest.beans.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
