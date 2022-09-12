package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SearchOrgpage {
	@FindBy(id="search_txt")
	private WebElement searchbox;
	
	@FindBy(name="search")
	private WebElement searchnow_box;
	
	@FindBy(linkText = "testyantra")
	
	private WebElement orgnamelist;
	
	public SearchOrgpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getSearchbox() {
		return searchbox;
	}

	
	public WebElement getSearchnow_box() {
		return searchnow_box;
	}

	
	public WebElement getOrgnamelist() {
		return orgnamelist;
	}
	public void setOrgname(String s)
	{
		searchbox.sendKeys(s);
		searchnow_box.click();
		orgnamelist.click();
		
	}

}
