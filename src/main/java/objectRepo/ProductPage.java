package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	@FindBy(id="search_txt")
	private WebElement search_box;
	
	@FindBy(name="search")
	private WebElement search_now;
	
	@FindBy(linkText = "dress")
	private WebElement search_list;
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearch_box() {
		return search_box;
	}

	public WebElement getSearch_now() {
		return search_now;
	}

	public WebElement getSearch_list() {
		return search_list;
	}
	
	public void setProductSearchBox(String pname)
	{
		search_box.sendKeys(pname);
		search_now.click();
		search_list.click();
	}
	
	

}
