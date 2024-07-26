package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain2 {

	public static void main(String[] args) {

		try {
		//	Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println("Driver loaded");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javadb", "root", "rasaspsi");
			// System.out.println("Connection created");

			Statement st = con.createStatement();
			
			st.executeUpdate("delete from employee where empid = 888");
			
			st.executeUpdate("insert into employee values(888,'Jaikishen',22222,'1978-5-26')");
			st.executeUpdate("insert into employee values(999,'Jaikishen',22222,'1978-5-26')");
			
			System.out.println("One row inserted");
			
			st.executeUpdate("update employee set salary = 88770 where empid = 100");
			
			con.close();
			
		} catch (SQLException  e) {

			e.printStackTrace();
		}
		
		

	}

}
