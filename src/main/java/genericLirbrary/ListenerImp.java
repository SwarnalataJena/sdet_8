package genericLirbrary;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class ListenerImp implements ITestListener{
	ExtentTest test;
	ExtentReports reports;
	
	@Override
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName()+"successful testcases");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"skipped testcases");
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter reporter=new ExtentSparkReporter("");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		reports.flush();
	}

	public void onTestFailure(ITestResult result) {
		String currentDate = new Date().toString().replace(" ", "_").replace(":", "_");
		String str=result.getMethod().getMethodName();
		EventFiringWebDriver t=new EventFiringWebDriver(BaseClass.sdriver);
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScrnShot/"+str+currentDate+".png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	

}
