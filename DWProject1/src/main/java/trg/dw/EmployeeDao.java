package trg.dw;

import java.util.List;

public interface EmployeeDao {

	Employee getEmployee(int id);

	List<Employee> getAllEmployees();

	void saveEmployee(Employee e);

	void deleteEmployee(int id);

	void updateEmployee(Employee e);

}
