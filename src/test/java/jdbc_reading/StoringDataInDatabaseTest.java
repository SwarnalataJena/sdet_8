package jdbc_reading;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;



public class StoringDataInDatabaseTest {
	@Test
	public void storingdbdata() throws Throwable
	{
		Connection con=null;
		try {
			//step1 register driver
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			
			//step2 get connection with the database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			
			//step3 create statement
			Statement stmt = con.createStatement();
			
			//step4 execute update
			int result = stmt.executeUpdate("insert into students_info(regno,firstname,middlename,lastname)values(8,'sai','k','narasingh')");
			if(result==1)
			{
				System.out.println("Data is inserted");
			}
			else
			{
				System.out.println("Data is not stored");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			System.out.println("connection is closed");
		con.close();
		}
		
	}

}
