package genericLirbrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import objectRepo.HomePageclass;
import objectRepo.LoginPageclass;

public class BaseClass {
	public WebDriverUtility wutil=new WebDriverUtility();
	public static WebDriver driver;
	public PropertyFileUtility p=new PropertyFileUtility();
	
	public static WebDriver sdriver;

	@BeforeSuite(groups = {"smoke","regression"})
	public void createConn()
	{
		System.out.println("=======connect to DB=======");	
	}
	//@Parameters("Browser")
	@BeforeClass(groups = {"smoke","regression"})
	public void openBrowser() throws Throwable
	{
		System.out.println("========open browser=======");
		
		String Browser = p.readDataFromPropertyFile("browser");
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		wutil.windowMaximize(driver);
		sdriver=driver;
		wutil.impwait(driver);
	}

	@BeforeMethod(groups = {"smoke","regression"})
	public void login() throws Throwable
	{
		System.out.println("=======login done======");
		driver.get(p.readDataFromPropertyFile("url"));
		LoginPageclass lpc=new LoginPageclass(driver);
		lpc.setLogin(p.readDataFromPropertyFile("un"),p.readDataFromPropertyFile("pwd"));
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void logout()
	{
		System.out.println("========logout done========");	
		HomePageclass hp=new HomePageclass(driver);
		hp.setLogout(driver);
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void closeBrowser()
	{
		System.out.println("========close browser=======");
		
		driver.close();
	}
	
	@AfterSuite(groups = {"smoke","regression"})
	public void closeConn()
	{
		System.out.println("=======close connection=======");
	}

}
