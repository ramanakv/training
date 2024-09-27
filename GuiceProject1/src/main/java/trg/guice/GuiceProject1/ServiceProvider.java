package trg.guice.GuiceProject1;

import com.google.inject.Provider;

public class ServiceProvider implements Provider<Service>  {

	@Override
	public Service get() {
		// based on some conditions relevent object is returned
		return new DbService();
	}
	
}
