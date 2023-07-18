package com.trg.boot;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	ProductRepository repo;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int producId) {

		Optional<Product> opt = repo.findById(producId);

		if (opt.isPresent()) {
			return opt.get();
		} else
			return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Product> getAll() {

		List<Product> list = repo.findAll();
		return list;
	}

	@RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String save(@RequestBody Product p) {
		Optional<Product> opt = repo.findById(p.getProductId());
		if (opt.isPresent()) {
			return "Product already exists";
		}
		repo.save(p);
		return "Product saved successfully";

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") int pid) {
		Optional<Product> opt = repo.findById(pid);
		if (opt.isPresent()) {
			repo.deleteById(pid);
			return "Product successfully deleted";
		}
	
		return "Product does not exist";
	}

}
