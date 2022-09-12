package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VenderNameSearch {
	@FindBy(name="search_text")
	private WebElement search_box;

	@FindBy(name="search")
	private WebElement search_now;
	
	@FindBy(linkText = "zzzz")
	private WebElement listvender;
	
	public VenderNameSearch(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the search_box
	 */
	public WebElement getSearch_box() {
		return search_box;
	}

	/**
	 * @return the search_now
	 */
	public WebElement getSearch_now() {
		return search_now;
	}

	
	public WebElement getListvender() {
		return listvender;
	}
	public void setvender(String venderName)
	{
		search_box.sendKeys(venderName);
		search_now.click();
		listvender.click();
		
	}

}
