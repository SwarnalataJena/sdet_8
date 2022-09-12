package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLirbrary.WebDriverUtility;

public class HomePageclass {
	WebDriverUtility wUtil=new WebDriverUtility();
	
	@FindBy(linkText = "Organizations")
	private WebElement orgbutton;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimage;

	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	
	@FindBy(linkText = "Contacts")
	private WebElement cntactbutton;
	
	@FindBy(linkText = "More")
	private WebElement morebtn;
	
	@FindBy(name="Purchase Order")
	private WebElement purcha_ordr;

	public HomePageclass(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	public WebElement getOrgbutton() {
		return orgbutton;
	}
	public WebElement getAdminimage() {
		return adminimage;
	}
	public WebElement getSignout() {
		return signout;
	}
	public WebElement getCntactbutton() {
		return cntactbutton;
	}
	public WebElement getMorebtn()
	{
		return morebtn;
	}
	public WebElement getPurcha_ordr()
	{
		return purcha_ordr;
	}

	public void setLogout(WebDriver driver)
	{
		wUtil.movemouse(driver, adminimage);
		signout.click();
	}
	public void setPurOrder(WebDriver driver)
	{
		wUtil.movemouse(driver, morebtn);
		purcha_ordr.click();
	}
	
}
