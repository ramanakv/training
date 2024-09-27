package trg.guice.GuiceProject1;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class AppModule  extends AbstractModule{

	@Override
	protected void configure() {
		
	/*	=======  Basic binding ===========*/
	//	bind(Service.class).to(JPaService.class);
	
		/*	=======  Named binding ===========*/
		
	//	bind(Service.class).annotatedWith(Names.named("JPA")).to(JPaService.class);
	//	bind(Service.class).annotatedWith(Names.named("DB")).to(DbService.class);
		
		/*	=======  Binding with a Provider ===========*/
	
		bind(Service.class).toProvider(ServiceProvider.class);
	}

}
