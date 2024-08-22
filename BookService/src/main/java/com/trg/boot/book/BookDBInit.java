package com.trg.boot.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


import com.trg.boot.book.entity.Book;
import com.trg.boot.book.repo.BookRepository;

@Service
public class BookDBInit implements CommandLineRunner {
	@Autowired
	BookRepository repo;

	Logger logger = LoggerFactory.getLogger(BookDBInit.class);

	@Override
	public void run(String... args) throws Exception {

		logger.info("Adding data to Book table");

		repo.save(new Book(100, "Learn java", 11, 111, 456.50f));
		repo.save(new Book(200, "Spring Boot", 11, 222, 456.50f));
		repo.save(new Book(300, "SQL Reference", 22, 111, 499.50f));
		repo.save(new Book(400, "Spring Guide", 33, 333, 199.50f));
		repo.save(new Book(500, "Java Web applications", 44, 222, 799.50f));
		repo.save(new Book(600, "Learn Microservices", 11, 444, 556.50f));

		logger.info("6 books added to database");

	}

}
