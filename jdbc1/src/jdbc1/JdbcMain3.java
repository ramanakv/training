package jdbc1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class JdbcMain3 {

	public static void main(String[] args) {
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javadb", "root", "rasaspsi");

			PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?)"); // statement is compiled

			pst.setInt(1, 777);
			pst.setString(2, "Sukumar");
			pst.setInt(3, 66666);
			Date dob = Date.valueOf(LocalDate.of(2000, 12, 15));
			pst.setDate(4, dob);

			pst.executeUpdate();
			
			System.out.println("One row inserted");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
