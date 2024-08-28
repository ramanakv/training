package com.trg.boot.pub;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("publishers")
public class PublisherController {
	
	@Autowired
	PublisherRepository repo;

	@GetMapping("{pid}")
	public ResponseEntity<?> getPublisher(  @PathVariable int pid){
		
		Optional<Publisher> opt=repo.findById(pid);
		if(opt.isPresent()) {
			return new ResponseEntity<Publisher>(opt.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Publisher not found",HttpStatus.NOT_FOUND);
		}
				
	}
}
