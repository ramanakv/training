package trg.helidon;

import java.net.URI;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class App {

	public static void main(String[] args) {

		BookRestClient client = RestClientBuilder.newBuilder()
				                                 .baseUri(URI.create("http://localhost:8080"))
				                                 .build(BookRestClient.class);

		 client.getAllBooks().forEach(System.out::println);

	//	System.out.println(client.deleteBookById(111));
/*
		Response response = null;

		try {
			response = client.getBookById(123);
			System.out.println(response.readEntity(Book.class));

		} catch (WebApplicationException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getResponse());
		}
	*/			
		//System.out.println(client.saveBook(new Book(100,"ancd","uth")).readEntity(String.class));
	}
}
