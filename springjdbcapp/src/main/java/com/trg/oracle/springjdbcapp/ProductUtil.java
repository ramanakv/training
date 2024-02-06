package com.trg.oracle.springjdbcapp;

import java.util.List;

public interface ProductUtil {
	boolean save(Product p);

	void update(Product p);

	Product getProduct(int id);

	List<Product> getAll();
}
