package makeMyTripTC;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTripWithCurrentDate {
	public static void main(String[] args) throws Throwable {
		Date d=new Date();
		String str = d.toString();
		String[] s = str.split(" ");
		String day = s[0];
		String month=s[1];
		String date=s[2];
		String year=s[5];
		String current_date=day+" "+month+" "+date+" "+year;

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://www.makemytrip.com/");

		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElement(By.className("close")).click();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();

		driver.findElement(By.id("fromCity")).sendKeys("banglore");
		driver.findElement(By.xpath("//div[text()='BLR']")).click();

		driver.findElement(By.id("toCity")).sendKeys("new york");
		driver.findElement(By.xpath("//div[text()='NYC']")).click();

		Thread.sleep(3000);		
		driver.findElement(By.xpath("//div[@aria-label='"+current_date+"']")).click();
//		driver.findElement(By.xpath("//div[@aria-label='Fri Sep 16 2022']")).click();
	}

}
