package reportsGeneration;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class Ext_Report {
	ExtentSparkReporter reporter; //path, look and feel
	ExtentReports reports;        //attach reporter and env variable
	ExtentTest test;              //To create entries
	
	@Test
	public void generateReport() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://facebook.com");
		reporter=new ExtentSparkReporter("./Reports/Facebook.html");
		reporter.config().setDocumentTitle("VTiger");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("regression");
		
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("browserversion", "105");
		reports.setSystemInfo("reporterName", "swarna");
		reports.setSystemInfo("build No", "5.3.2");
		reports.setSystemInfo("OS", "windows10");
		
	    test=reports.createTest("facebook");
	    TakesScreenshot shot = (TakesScreenshot)driver;
	    File src = shot.getScreenshotAs(OutputType.FILE);
	    String path="../SDET_HYD_8/ScrnShot/asd.png";
	    File dest=new File(path);
	    Files.copy(src, dest);
	    
	    test.addScreenCaptureFromPath(path);
	    
	    test.log(Status.FAIL, "got failed");
	    
	    reports.flush();
	    
	}
	

}
