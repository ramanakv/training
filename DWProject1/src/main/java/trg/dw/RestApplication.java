package trg.dw;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;

public class RestApplication  extends Application<MessageConfiguration>{

	public static void main(String[] args) throws Exception {
	  new RestApplication().run("server","dw.yml");	
	}
	
	@Override
	public void run(MessageConfiguration configuration, Environment environment) throws Exception {
		// register all Resource objects
		MessageResource messageResource = new MessageResource(configuration);
		EmployeeResource employeeResource = new EmployeeResource(new EmployeeJpaDaoImpl());
		
		environment.jersey().register(employeeResource);
		environment.jersey().register(messageResource);			
	}
	
	

}
