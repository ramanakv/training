package com.facade;

import java.sql.Connection;

public class ProductUtil {

	Connection con;

	public ProductUtil(Connection con) {
		super();
		this.con = con;
	}
	
	public int getQuantity(int itemCode) {
		// gets value from database
		return 195;
	}
	
	public int getMinLevel(int itemCode) {
		
		// gets value from database
		return 200;
	}
	
}
