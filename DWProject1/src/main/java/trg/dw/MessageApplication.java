package trg.dw;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;

public class MessageApplication  extends Application<MessageConfiguration>{

	public static void main(String[] args) throws Exception {
	  new MessageApplication().run("server","dw.yml");	
	}
	
	@Override
	public void run(MessageConfiguration configuration, Environment environment) throws Exception {
		// register all Resource objects
		MessageResource resource = new MessageResource(configuration);
		
		environment.jersey().register(resource);		
		
		
	}
	
	

}
