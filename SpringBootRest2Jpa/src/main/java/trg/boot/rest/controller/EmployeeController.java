package trg.boot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trg.boot.rest.beans.Employee;
import trg.boot.rest.beans.ResponseMessage;
import trg.boot.rest.service.EmployeeService;

@RestController
@RequestMapping("employees")

public class EmployeeController {


	
//	@Value("${service.name}")
//	String beanName;
	
	@Autowired
	@Qualifier("jpaservice")
	EmployeeService service;

/*	
	@Autowired
	public EmployeeController(ApplicationContext ctx) {
		super();
		
		service = ctx.getBean(beanName,EmployeeService.class);
	}
*/
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployees() {
		List<Employee> list = service.getAllEmployees();
		return list;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public Employee getEmployee(@PathVariable("id") int eid) {
		Employee e = service.getEmployee(eid);
		return e;
	}

//	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	@PostMapping
	public ResponseMessage saveEmployee(@RequestBody Employee e) {
		String resp = service.saveEmployee(e);
		return new ResponseMessage(resp);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseMessage updateEmployee( @RequestBody  Employee e) {
		String resp = service.updateEmployee(e);
		return new ResponseMessage(resp);
	}

	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseMessage deleteEmployee(@PathVariable("id") int eid) {

		String resp = service.deleteEmployee(eid);
		return new ResponseMessage(resp);
	}

}
