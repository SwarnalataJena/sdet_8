package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	@FindBy(name="firstname")
	private WebElement firstname;

	@FindBy(name="lastname")
	private WebElement lastname;

	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgnameplussymbol;

	@FindBy(name="button")
	private WebElement savebutton;

	@FindBy(name="salutationtype")
	private WebElement Mrms;

	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getMrms()
	{
		return Mrms;
	}

	public WebElement getFirstname() {
		return firstname;
	}


	public WebElement getLastname() {
		return lastname;
	}


	public WebElement getOrgnameplussymbol() {
		return orgnameplussymbol;
	}


	public WebElement getSavebutton() {
		return savebutton;
	}
	public void setMrFiLa(String stname,String fname,String lname)
	{
		Mrms.sendKeys(stname);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		orgnameplussymbol.click();
		
	}


}
