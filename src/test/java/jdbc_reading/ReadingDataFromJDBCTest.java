package jdbc_reading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ReadingDataFromJDBCTest {
	@Test
	public static void readingJDBCdata() throws Throwable
	{
		Connection con=null;   																				 //step2 connect the database
		try {
			
			Driver d=new Driver();
			DriverManager.registerDriver(d);  																 //step1 register the driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			Statement stmt = con.createStatement();     													//step3 create statement
			ResultSet result = stmt.executeQuery("select * from students_info;");  							 //step4 execute query
			while(result.next())
			{
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(4));
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
	        System.out.println("connection is closed");
	        con.close();                               														 //step5 close connection
		}
	}

}
