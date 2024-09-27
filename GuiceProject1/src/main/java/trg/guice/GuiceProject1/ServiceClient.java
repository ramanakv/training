package trg.guice.GuiceProject1;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ServiceClient {
	
	@Inject
	//@Named("JPA")
	Service service;
	
	public void show() {
		
		System.out.println(service.getMessage());
	}

}
