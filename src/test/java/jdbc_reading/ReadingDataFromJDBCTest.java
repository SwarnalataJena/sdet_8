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
		//step2 connect the database
		Connection con=null;
		try {
			//step1 register the driver
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			
			//step3 create statement
			Statement stmt = con.createStatement();
			
			//step4 execute query
			ResultSet result = stmt.executeQuery("select * from students_info;");
			
			while(result.next())
			{
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(4));
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
	    //step5 close connection
			System.out.println("connection is closed");
	        con.close();
		}
	}

}
