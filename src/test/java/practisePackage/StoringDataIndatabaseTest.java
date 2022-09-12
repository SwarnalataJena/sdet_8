package practisePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class StoringDataIndatabaseTest {
	@Test
	public static void storedataindatabase() throws Throwable
	{
		Connection con=null;
		try {
			Driver d=new Driver();
			DriverManager.registerDriver(d);

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");

			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate("insert into students_info(regno,firstname,middlename,lastname)values(9,'rama','g','nujam')");
			if(result==1)
			{
				System.out.println("value is inserted");
			}
			else
			{
				System.out.println("Value is not inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		con.close();
		System.out.println("Connection is closed");
		}



	}

}
