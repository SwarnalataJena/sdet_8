package practiseTestcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ListPriceTest{
	@Test
	public void listPriceTest()
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
		for(WebElement x:dprices)
		{

			System.out.println(x.getText());
		}
		System.out.println("========");

		WebElement dropele = driver.findElement(By.xpath("//span[text()=' Popular ']"));
		act.moveToElement(dropele).perform(); 

		driver.findElement(By.xpath("//a[text()='Price Low to High ']")).click();
		List<WebElement> sprices = driver.findElements(By.xpath("//span[@class='new-price']"));
		for(WebElement y:sprices)
		{

			System.out.println(y.getText());
		}

		for(int i=0;i<sprices.size();i++)
		{
			if(dprices.equals(sprices))
			{
				System.out.println("prices are same");
			}
			else
			{
			System.out.println("prices are not same");
			}
		}
        driver.close();

	}


}
