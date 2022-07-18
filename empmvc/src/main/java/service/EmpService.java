package service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import data.Employee;

public class EmpService {

	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	public EmpService() {

		empData.put(100, new Employee(100, "Suresh", 35000, LocalDate.of(1997, 8, 15)));
		empData.put(200, new Employee(200, "Naresh", 25000, LocalDate.of(1998, 10, 25)));
		empData.put(300, new Employee(300, "Manish", 23000, LocalDate.of(1999, 6, 17)));
		empData.put(400, new Employee(400, "Ritesh", 37000, LocalDate.of(1999, 4, 5)));
		empData.put(500, new Employee(500, "Mahesh", 21000, LocalDate.of(1992, 5, 1)));
		empData.put(600, new Employee(600, "Satish", 37000, LocalDate.of(1994, 10, 22)));
		empData.put(700, new Employee(700, "Rajech", 16000, LocalDate.of(1988, 12, 18)));

	}

	public String getEmployee(HttpServletRequest request) {

		String empIdStr = request.getParameter("empid");

		try {
			int eid = Integer.parseInt(empIdStr);
			Employee e = empData.get(eid);
			if (e == null) {
				request.setAttribute("message", "Employee with id " + eid + " not found");
				return "response";

			} else {

				request.setAttribute("emp", e);
				return "empdata";
			}
		} catch (NumberFormatException ne) {
			request.setAttribute("message", "Invalid Number for Emp Id -- " + empIdStr);
			return "response";
		}

	}

	public String saveEmployee(HttpServletRequest request) {

		String empIdStr = request.getParameter("empid");
		int eid = 0;
		try {
			eid = Integer.parseInt(empIdStr);
			// check if same id exists
			if (empData.containsKey(eid)) {
				request.setAttribute("message", "Employee with  Id " + eid + " already exists");
				return "response";
			}
		} catch (NumberFormatException ne) {
			request.setAttribute("message", "Invalid Number for Emp Id -- " + empIdStr);
			return "response";
		}

		String name = request.getParameter("name");
		String salStr = request.getParameter("salary");
		float sal = 0;
		try {
			sal = Float.parseFloat(salStr);
		} catch (NumberFormatException ne) {
			request.setAttribute("message", "Invalid Number for Salary -- " + salStr);
			return "response";
		}
		String dobStr = request.getParameter("dob");
		LocalDate dob = null;
		try {
			dob = LocalDate.parse(dobStr);
		} catch (DateTimeParseException ndte) {
			request.setAttribute("message", "Invalid Date for DOB -- " + dobStr);
			return "response";
		}

		empData.put(eid, new Employee(eid, name, sal, dob));
		request.setAttribute("message", "Employee with  Id " + eid + " successfully saved");
		return "response";
	}

	public String deleteEmployee(HttpServletRequest request) {
		String empIdStr = request.getParameter("empid");
		try {
			int eid = Integer.parseInt(empIdStr);
			if (empData.containsKey(eid)) {
				empData.remove(eid);
				request.setAttribute("message", "Employee with  Id " + eid + " successfully deleted");
			} else {
				request.setAttribute("message", "Employee with id " + eid + " to delete  not found");
			}

			return "response";

		} catch (NumberFormatException ne) {
			request.setAttribute("message", "Invalid Number for Emp Id -- " + empIdStr);
			return "response";
		}
	}

}
