package practisePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


public class ReadingDataFromDatabaseTest {
	@Test
	public static void dataBaseReading() throws Throwable
	{
		//step1 register driver
		//step2 get connection
		Connection con=null;
		try {
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			
			//step3 create statement
			Statement stmt = con.createStatement();
			
			//step4 execute query
			ResultSet result = stmt.executeQuery("select * from students_info;");
			
			while(result.next())
			{
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally
		 {
		//step5 close the connection
		con.close();
		System.out.println("connection is closed");
		 }
		
		
	}

}
