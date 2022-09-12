package genericLirbrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImp implements ITestListener{
	ExtentTest test;
	ExtentReports reports;
	
	@Override
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName()+"test execution started");		
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
		ExtentSparkReporter reporter=new ExtentSparkReporter(IPathConstant.EXTREPORTPATH+JavaUtility.manageDate());
		reporter.config().setDocumentTitle("VTiger");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("smoke");
		
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("browser version", "105");
		reports.setSystemInfo("platform", "windows10");
		reports.setSystemInfo("build no", "4.2");
		reports.setSystemInfo("reporter name", "swarna");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		reports.flush();
	}

	public void onTestFailure(ITestResult result) {
//		String currentDate = new Date().toString().replace(" ", "_").replace(":", "_");
		String str=result.getMethod().getMethodName();
		TakesScreenshot t=(TakesScreenshot)BaseClass.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScrnShot/"+str+JavaUtility.manageDate()+".png");
		
		test.log(Status.FAIL,result.getMethod().getMethodName()+"failed testcase");
		test.log(Status.FAIL, result.getThrowable());
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	
	

}
