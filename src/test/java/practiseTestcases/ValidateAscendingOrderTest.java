package practiseTestcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ValidateAscendingOrderTest {
	private static final TreeSet String = null;

	@Test
	public void validateAscendingTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bluestone.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("denyBtn")).click();

		WebElement ele = driver.findElement(By.xpath("//a[text()='Rings ']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Diamond Rings']")).click();


		List<WebElement> dprices = driver.findElements(By.xpath("//span[@class='new-price']"));

		WebElement dropele = driver.findElement(By.xpath("//span[text()=' Popular ']"));
		act.moveToElement(dropele).perform(); 

		driver.findElement(By.xpath("//a[text()='Price Low to High ']")).click();
		List<WebElement> sprices = driver.findElements(By.xpath("//span[@class='new-price']"));

		String s = sprices.toString();
		TreeSet<String> t=new TreeSet<String>();
		t.add(s);
		
		for(int i=0;i<t.size();i++)
		{
			if(t.equals(s))
			{
				System.out.println("ascending order");
			}
			System.out.println("not ascending order");
		}
		
	}

}
