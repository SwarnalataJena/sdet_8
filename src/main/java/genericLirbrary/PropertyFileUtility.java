package genericLirbrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility {
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstant.PROPERTYFILEPATH);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}

}
