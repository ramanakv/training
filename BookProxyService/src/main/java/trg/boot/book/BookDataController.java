package trg.boot.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("bookdata")
public class BookDataController {

	RestTemplate client = new RestTemplate();

	String bookUrl = "http://localhost:8081/books/{id}";
	String authorUrl = "http://localhost:8082/authors/{id}";
	String publisherUrl = "http://localhost:8083/publishers/{id}";

	@GetMapping("{id}")
	public ResponseEntity<?> getBookdata(@PathVariable("id") int id) {
		try {
			Book book = client.getForObject(bookUrl, Book.class, id);

			BookData data = new BookData(book.bookId(), book.title(), book.price());

			int authorId = book.authorId();
			int publisherId = book.publisherId();

			// connect to AuthorService
			try {
				Author author = client.getForObject(authorUrl, Author.class, authorId);
				data.setAuthor(author);
			} catch (HttpClientErrorException ex) {
				data.setAuthor(null);
			}

			// connect to PublisherService
			try {
				Publisher publisher = client.getForObject(publisherUrl, Publisher.class, publisherId);
				data.setPublisher(publisher);
			} catch (HttpClientErrorException ex) {
				data.setPublisher(null);
			}
			
			return new ResponseEntity<BookData>(data, HttpStatus.OK);

		} catch (HttpClientErrorException ex) {
			String message = ex.getResponseBodyAsString();
			return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
		}
	}

}
