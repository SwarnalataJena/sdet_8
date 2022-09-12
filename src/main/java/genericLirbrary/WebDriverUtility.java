package genericLirbrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * This is created for maximize the window
	 * @author Swarnalata
	 * @param driver
	 */

	public void windowMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This is created for implicitwait
	 * @author Swarnalata
	 */
	public void impwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	/**
	 * This is created for explicit wait
	 * @author Swarnalata
	 */
	public void expwait(WebDriver driver,WebElement ele)
	{
		WebDriverWait ww=new WebDriverWait(driver, 30);
		ww.until(ExpectedConditions.visibilityOf(ele));		
	}
	/**
	 * This is created for to handle selectclass for index value
	 * @author Swarnalata
	 */
	public void selectingByIndex(WebElement ele,int index)
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	public void selectingByValue(WebElement ele,String value)
	{
		Select s=new Select(ele);
		s.selectByValue(value);
	}
	public void selectingByVisibleText(WebElement ele,String text)
	{
		Select s=new Select(ele);
		s.selectByValue(text);
	}
	/**
	 * This is created to handle the mouse
	 * @author Swarnalata
	 */
	public void movemouse(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	public void doubleclickmouse(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
	}
	public void rightclickmouse(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).contextClick().build().perform();
	}
	/**
	 * This is created to handle the multiple frames
	 * @author Swarnalata
	 */
	public void indexswitchFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index); 
	}
	public void webeleswitchFrame(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	public void stringswitchFrame(WebDriver driver,String s) 
	{
		driver.switchTo().frame(s); 
	}
  /**
   * This is for swithingwindow
   * @author Swarnalata
   */
    public void switchingwindow(WebDriver driver,String partialwindowText)
    {
    	Set<String> win = driver.getWindowHandles();
    	Iterator<String> it = win.iterator();
    	while(it.hasNext()) 
    	{
    		String winid=it.next();
    		String title=driver.switchTo().window(winid).getTitle();
    		if(title.contains(partialwindowText))
    		{
    			break;
    		}
    	}
    }
    /**
     * this is created to handle enterbutton
     * @author Swarnalata
     * @throws AWTException
     */
    public void handlingEnterButton() throws AWTException
    {
    	Robot r=new Robot();
    	r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
    }
    /**
     * this is created to handle take screenshot
     * @author Swarnalata
     * @param driver
     * @throws IOException
     */
    public void screenphototake(WebDriver driver) throws IOException
    {
    	TakesScreenshot t=(TakesScreenshot)driver;
    	 File src = t.getScreenshotAs(OutputType.FILE);
    	 File dist=new File("./screenshot");
    	 Files.copy(src, dist);
    	
    }
    /**
     * This is created to handle to refresh the page
     * @author Swarnalata
     * @param driver
     */
    public void handleRefresh(WebDriver driver)
    {
    	Navigation nav=driver.navigate();
    	nav.refresh();
    }
    /**
     * This is created to handle drag and drop
     * @author Swarnalata
     * @param driver
     * @param src
     * @param dist
     */
    public void handleDragDrop(WebDriver driver,WebElement src,WebElement dist)
    {
    	Actions act=new Actions(driver);
    	act.dragAndDrop(src, dist);
    }
    /**
     * This to created to scroll the page
     * @author Swarnalata
     * @param driver
     * @param x
     * @param y
     */
    public void mouseScrolling(WebDriver driver)
    {
    	JavascriptExecutor jse=(JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(x,y);");
    }
    public void handleAlt(WebDriver driver)
    {
    	Alert alt=driver.switchTo().alert();
    	alt.accept();	
    }
   
}
