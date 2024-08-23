package trg.helidon;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.json.JsonObject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/books")
//@RegisterRestClient(baseUri = "http://localhost:8080")
interface BookRestClient {

	@GET
	public List<Book> getBooks();

	@GET
	@Path("{bookId}")
	public Response getBookById(@PathParam("bookId") int bookId);

	@GET
	public List<Book> getAllBooks();

	@POST
	public Response saveBook(Book book);

	@PUT
	public String updateBook(Book book);

	@DELETE
	@Path("{bookId}")
	public String deleteBookById(@PathParam("bookId") int bookId);

}
