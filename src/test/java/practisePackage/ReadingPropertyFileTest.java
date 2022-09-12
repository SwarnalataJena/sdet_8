package practisePackage;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadingPropertyFileTest {
	@Test
	public void readingProp() throws Throwable
	{
		FileInputStream fis=new FileInputStream("./PropFile.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty("url");
		String username =prop.getProperty("un");
		String password=prop.getProperty("pwd");
		System.out.println(value);
		System.out.println(username);
		System.out.println(password);
		
	}

}
