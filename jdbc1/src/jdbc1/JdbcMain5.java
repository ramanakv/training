package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcMain5 {

	public static void main(String[] args) {
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javadb", "root", "rasaspsi");

			PreparedStatement pst = con.prepareStatement("update employee set salary = ? where empid = ?"); 

			Scanner sc = new Scanner(System.in);

			while (true) {
				System.out.println("Enter emp id (-1 to stop)");
				int eid = sc.nextInt();
				if(eid == -1)
					break;
				System.out.println("Enter new salary for empid "+eid);
				int sal = sc.nextInt();
				
				pst.setInt(1, sal);
				pst.setInt(2, eid);
				int count = pst.executeUpdate();
				
				if(count == 0) {
					System.out.println("Empid "+ eid +" not found");
				}
				else {
					System.out.println("Salary of employee with id "+ eid + " changed to "+sal);
				}
				
			}
			
			con.close();
			System.out.println("Thank you Bye!!");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
