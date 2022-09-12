package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLirbrary.WebDriverUtility;

public class CreateOrganizationPageclass {
	WebDriverUtility wUtil=new WebDriverUtility();
	
	@FindBy(name="accountname")
	private WebElement orgname;
	
	@FindBy(name="industry")
	private WebElement indtype;
	
	@FindBy(name="button")
	private WebElement savebtn;

	public CreateOrganizationPageclass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getIndtype() {
		return indtype;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void setaccsave(String orgName)
	{
		orgname.sendKeys(orgName);
		savebtn.click();
	}
	
	public void setaccindsave(String orgName,String indtype)
	{
		orgname.sendKeys(orgName);
		wUtil.selectingByValue(getIndtype(), indtype);
		savebtn.click();
	}
	
	

}
