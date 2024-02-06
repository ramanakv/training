package com.trg.oracle.springjdbcapp;

import java.util.List;

public class ProductUtilMain {

	public static void main(String[] args) {
		ProductUtil util = new ProductUtilImpl();
		List<Product> list = util.getAll();

		System.out.println(list);

		Product p = new Product(200, "Dining Table", 25000);

		if (util.save(p)) {
			System.out.println("Product with id " + p.getProductId() + " saved successfully");
		} else {
			System.out.println("Product with id " + p.getProductId() + " already exists");
		}

		Product p1 = util.getProduct(100);
		if (p1 != null)
			System.out.println(p1);
		else
			System.out.println("Product not available");
		util.update(new Product(100,"", 22222));
	}

}
