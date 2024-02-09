package com.trg.boot.pub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


@Service
public class PublisherDBInit implements CommandLineRunner {

	@Autowired
	PublisherRepository repo;

	Logger logger = LoggerFactory.getLogger(PublisherDBInit.class);

	@Override
	public void run(String... args) throws Exception {

		logger.info("Adding data to Publisher table");

		repo.save(new Publisher(11, "Tech Publishers", "Delhi"));
		repo.save(new Publisher(22, "Whatsup Limited", "Hyderabad"));
		repo.save(new Publisher(33, "BPB Publications", "Mumbai"));

		logger.info("3 publishers added to database");

	}

}
