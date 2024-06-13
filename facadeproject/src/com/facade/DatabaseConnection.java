package com.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public Connection createConnection() {
		Connection con=null;

		try {
			con = DriverManager.getConnection("URL");
			return con;
		} catch (SQLException e) {

		}

		return con;
	}

}
