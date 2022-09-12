package practisePackage;

import org.testng.annotations.Test;

public class ReadingDataFromCMDTest {
	@Test
	public void cmdReading()
	{
		String value=System.getProperty("url");
		String username=System.getProperty("un");
		String password=System.getProperty("pwd");
		
		System.out.println(value);
		System.out.println(username);
		System.out.println(password);
	}

}
