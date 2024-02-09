package com.trg.ms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.trg.ms.entity.*;
import com.trg.ms.entity.BookData;

@RestController
@RequestMapping("bookData")
public class BookDataController {

	String bookUrl = "http://localhost:8081/books/{id}";
	String authorUrl = "http://localhost:8083/authors/{id}";
	String publisherUrl = "http://localhost:8082/publishers/{id}";

	RestTemplate template = new RestTemplate();

	@GetMapping("{id}")
	public ResponseEntity<?> getBookData(@PathVariable("id") int bookId) {
		try {
			Book b = template.getForObject(bookUrl, Book.class, bookId);

			BookData bookData = new BookData();
			bookData.setBookId(b.getBookId());
			bookData.setTitle(b.getTitle());
			bookData.setPrice(b.getPrice());

			int authorId = b.getAuthorId();

			try {
				Author author = template.getForObject(authorUrl, Author.class, authorId);
				bookData.setAuthor(author);
			} catch (HttpClientErrorException ex) {
				bookData.setAuthor(null);
			}

			int publisherId = b.getPublisherId();

			try {
				Publisher publisher = template.getForObject(publisherUrl, Publisher.class, publisherId);
				bookData.setPublisher(publisher);
			} catch (HttpClientErrorException ex) {
				bookData.setPublisher(null);
			}

			return new ResponseEntity<BookData>(bookData, HttpStatus.OK);

		} catch (HttpClientErrorException ex) {
			String message = ex.getResponseBodyAsString();
			return new ResponseEntity<String>(message, ex.getStatusCode());

		}

	}

}
