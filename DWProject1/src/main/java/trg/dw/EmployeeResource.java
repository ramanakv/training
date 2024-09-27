package trg.dw;

import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response.Status;

@Path("employees")
public class EmployeeResource {

	EmployeeDao dao;

	public EmployeeResource(EmployeeDao dao) {
		super();
		this.dao = dao;
	}

	@Path("{empid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("empid") int id) {
		Employee e = dao.getEmployee(id);
		if (e == null) {
			throw new WebApplicationException("Employee with id " + id + " not found", Status.NOT_FOUND);
		}

		return e;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String saveEmployee(Employee e) {
		if (dao.getEmployee(e.getEmpId()) == null) {
			dao.saveEmployee(e);
			return "Employee successfully saved";
		}

		return "Employee with id " + e.getEmpId() + " already exists";
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public String updateEmployee(Employee e) {
		if (dao.getEmployee(e.getEmpId()) == null) {
			return "Employee data to update doen not exist";
		}

		dao.updateEmployee(e);
		return "Employee data successfully updated";
	}

	@DELETE
	@Path("{empid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String saveEmployee(@PathParam("empid") int id) {
		if (dao.getEmployee(id) == null) {

			return "Employee data to delete does not exist";
		}
		dao.deleteEmployee(id);
		return "Employee data successfully deleted";
	}
}
