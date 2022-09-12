package practisePackage;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadingDataFromJsonTest {
	@Test
	public void jsonFilereading() throws Throwable
	{
		FileReader fr=new FileReader("./JNFile.json");
		JSONParser jsp=new JSONParser();
		Object jobj = jsp.parse(fr);
		HashMap hp=(HashMap)jobj;
		String value=(String)hp.get("url");
		String username=(String)hp.get("un");
		String password=(String)hp.get("pwd");
		System.out.println(value);
		System.out.println(username);
		System.out.println(password);
	}

}
