package trg.helidon;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.helidon.http.Status;
import io.helidon.webserver.Routing;
import io.helidon.webserver.http.Handler;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class BookService implements HttpService {

	@Override
	public void routing(HttpRules rules) {

		rules
			.get("/{id}", this::getBookById)
			.get("/", this::getAllBooks)
			.post("/", this::saveBook)   
			.put("/", this::updateBook)
			.delete("/{id}", this::deleteBook);

	}

	private void getBookById(ServerRequest request, ServerResponse response) {

		int bookId = Integer.parseInt(request.path().pathParameters().get("id"));

		Book b = BookManager.get(bookId);

		if (b != null)
			response.status(Status.OK_200).send(b);
		else
			response.status(404).send("Book with id " + bookId + " not found");
	}

	private void getAllBooks(ServerRequest request, ServerResponse response) {
		List<Book> books = BookManager.getAll();
		response.status(200).send(books);
	}
	
	

	private void saveBook(ServerRequest request, ServerResponse response) {

		Book book = request.content().as(Book.class);
		if (BookManager.add(book)) {
			response.status(Status.CREATED_201).send("Book with id " + book.getId() + " successfully saved");
		} else {
			response.status(Status.BAD_REQUEST_400).send("Book with id " + book.getId() + " already exists");
		}

	}


	private void updateBook(ServerRequest request, ServerResponse response) {

		Book book = request.content().as(Book.class);
		if (BookManager.update(book)) {
			response.status(Status.ACCEPTED_202).send("Book with id " + book.getId() + " successfully updated");
		} else {
			response.status(Status.BAD_REQUEST_400).send("Book with id " + book.getId() + " does not exist");
		}

	}

	private void deleteBook(ServerRequest request, ServerResponse response) {

		int bookId = Integer.parseInt(request.path().pathParameters().get("id"));

		if (BookManager.delete(bookId)) {
			response.status(Status.ACCEPTED_202).send("Book with id " + bookId + " successfully deleted");
		} else {
			response.status(Status.BAD_REQUEST_400).send("Book with id " + bookId + " does not exist");
		}

	}

}
