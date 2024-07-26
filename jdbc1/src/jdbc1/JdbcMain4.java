package jdbc1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class JdbcMain4 {

	public static void main(String[] args) {
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javadb", "root", "rasaspsi");

			PreparedStatement pst = con.prepareStatement("delete from employee where empid = ?"); // statement is compiled

			int empids[] = { 100, 701, 702, 666 };

			for (int eid : empids) {
				pst.setInt(1, eid);

				int rows = pst.executeUpdate();
				if (rows == 1)
					System.out.println("Data with id " + eid + " successfully deleted");
				else
					System.out.println("Data with id " + eid + " not found");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
