package com.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.entity.Employee;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("employees")
@ApplicationScoped // we want this object for the application. otherwise new object created for every request
public class EmployeeResource {

	TreeMap<Integer, Employee> data = new TreeMap<Integer, Employee>();
	
	public EmployeeResource() {
		super();
		
		data.put(100, new Employee(100, "Kumar", 62000));
		data.put(200, new Employee(200, "Kiran", 45000));
		data.put(400, new Employee(400, "Suresh", 40000));
		data.put(300, new Employee(300, "Manasi", 88000));
		data.put(500, new Employee(500, "Alok", 45120));
	}
	
	/* Use this URL --> http://localhost:8080/restapp/app/employees   */
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees(){
		Collection<Employee> col = data.values();
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.addAll(col);
		return list;
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	// method returns Response as it generates Employee object and String object
	//Response as a container can be used to return any type of data
	// Response can also be used to send HTTP status codes
	public Response getEmployee(  @PathParam("id") int eid) {
		Employee e = data.get(eid);
		if(e != null) {
			return Response.status(Response.Status.OK).entity(e).build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).entity("Employee with id "+ eid+" not found").build();
		}
	}
	
	@Path("/")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveEmployee(Employee e) {
		if(data.containsKey(e.getEmpId())) {
			return  Response.status(Response.Status.NOT_ACCEPTABLE).entity("Employee with id "+e.getEmpId()+ " already exists").build();
		}
		
		else {
			data.put(e.getEmpId(), e);
			return  Response.status(Response.Status.OK).entity("Employee with id " + e.getEmpId()+ " successfully saved").build();
		}
	}
	@Path("/{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployee( @PathParam("id") int empId) {
		
		if(data.containsKey(empId)) {
			data.remove(empId);
			return "Employee with id "+empId+ " successfully deleted";
		}
		else {
			return "Employee with id " + empId+ " not found";
		}
	}
	@Path("/")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateEmployee(Employee e) {
		
		if(data.containsKey(e.getEmpId())) {
			data.put(e.getEmpId(), e);
			return "Employee with id "+e.getEmpId()+ " successfully updated";
		}
		else {
			return "Employee with id " + e.getEmpId()+ " not found";
		}
	}
}
