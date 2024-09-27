package trg.guice.GuiceProject1;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceMain {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AppModule());
		
		ServiceClient client = injector.getInstance(ServiceClient.class);
		
		client.show();

	}

}
