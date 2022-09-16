package makeMyTripTC;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTripWithFutureDate {
	@Test
	public void futureDate()
	{
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
				
				for(int i=0;i<12;i++)
				{
					try {
						driver.findElement(By.xpath("//div[@aria-label='Wed Feb 08 2023']")).click();
					} catch (Exception e) {
						driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
					}
				}
				
			}
	

}
