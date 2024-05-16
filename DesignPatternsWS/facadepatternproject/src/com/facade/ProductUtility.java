package com.facade;

import java.sql.Connection;

public class ProductUtility {

	public Product getProduct(Connection con, int id) {
		// gets data from database
		return new Product(id,"Laptop",45000);
	}

}
