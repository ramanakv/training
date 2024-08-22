package com.trg.boot.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class AuthorDbInit implements CommandLineRunner {

	@Autowired
	AuthorRepository repo;
	
	Logger logger = LoggerFactory.getLogger(AuthorDbInit.class);

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Adding data to Author table");
		
		repo.save(new Author(111, "Ramesh Kulkarni","java"));
		repo.save(new Author(222, "Rajesh rao","spring"));
		repo.save(new Author(333, "Jamish Khaitan","SQL"));
		
		logger.info("3 authors added to the table");
	}

}
