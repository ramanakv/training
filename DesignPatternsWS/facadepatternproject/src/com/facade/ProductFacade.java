package com.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductFacade {

	Connection con;

	public ProductFacade() {

// create a databse connection here
	}

	public Product lowStock(int id) {

		ProductUtility pu = new ProductUtility();
		Product p = pu.getProduct(con, id);

		StoreUtil su = new StoreUtil();

		StoreData data = su.getStoreData(id, con);

		if (data.getBalance() <= data.getRol()) {
			return p;
		} else {
			return null;
		}

	}

}
