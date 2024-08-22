package com.trg.boot.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
	AuthorRepository repo;

	@GetMapping("{aid}")
	public ResponseEntity<?> getAuthor(@PathVariable int aid){
		Optional<Author> opt=repo.findById(aid);
		if(opt.isPresent()) {
			return new ResponseEntity<Author>(opt.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Author not found",HttpStatus.NOT_FOUND);
		}
	}
}
