package practiseTestcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IphonePriceComparisionTest {
	@Test
	public void flipkartAmazonIphonePrice()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Iphone 13");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Midnight, 128 GB)']")).click();
		Set<String> win_id = driver.getWindowHandles();
		for(String id:win_id)
		{
			String win_titles = driver.switchTo().window(id).getTitle();
			if(win_titles.contains("iphone-13-midnight-128"))
			{
				driver.switchTo().window(win_titles);
			}
		}
		String fprice=driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
		
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 13");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("(//span[text()='Apple iPhone 13 (128GB) - Midnight'])[3]")).click();
		Set<String> awin_id = driver.getWindowHandles();
		for(String aid :awin_id)
		{
			String atitle = driver.switchTo().window(aid).getTitle();
			if(atitle.contains("iPhone-13-128GB-Midnight"))
			{
				driver.switchTo().window(atitle);
			}
		}
		String aprice = driver.findElement(By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
		
		String fp = fprice.replaceAll("[^0-9]", "");
		String ap = aprice.replaceAll("[^0-9]", "");
		int f = Integer.parseInt(fp);
		int a = Integer.parseInt(ap);
		if(f>a)
		{
			System.out.println("More price :"+fprice);
		}
		else
		{
			System.out.println("Less price :"+aprice);
		}
	}

}
