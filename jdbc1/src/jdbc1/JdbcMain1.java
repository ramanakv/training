package jdbc1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javadb", "root", "rasaspsi");

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select * from employee order by dob");

		while (rs.next()) {

			int eid = rs.getInt("empid");
			String name = rs.getString(2);
			Date dob = rs.getDate("dob");
			int sal = rs.getInt("salary");

			System.out.println(eid + "   " + name + "  " + dob + "   " + sal);

		}

		con.close();
	}

}
