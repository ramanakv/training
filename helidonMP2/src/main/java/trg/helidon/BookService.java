package trg.helidon;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/books")
@RequestScoped
public class BookService {

	@GET
	@Path("{bookId}")
	public Response getBookById(@PathParam("bookId") int bookId) {

		Book b = BookManager.get(bookId);
		if (b != null)
			return Response.ok(b).build();
		else
			return Response.status(404).entity("Book with id " + bookId + " not found").build();
	}

	@GET
	public List<Book> getAllBooks() {
		List<Book> books = BookManager.getAll();
		return books;
	}

	@POST
	public Response saveBook(Book book) {
		if (BookManager.add(book)) {
			return Response.ok().entity("Book with id " + book.id() + " successfully saved").build();
		} else {
			return Response.status(400).entity("Book with id " + book.id() + " already exists").build();
		}

	}

	@PUT
	public String updateBook(Book book) {

		if (BookManager.update(book)) {
			return "Book with id " + book.id() + " successfully updated";
		} else {
			return "Book with id " + book.id() + " does not exist";
		}

	}

	@DELETE
	@Path("{bookId}")
	public String deleteBookById(@PathParam("bookId") int bookId) {

		if (BookManager.delete(bookId)) {
			return "Book with id " + bookId + " successfully deleted";
		} else {
			return "Book with id " + bookId + " does not exist";
		}

	}

}
