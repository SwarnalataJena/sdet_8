package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPageclass {
	@FindBy(className="dvHeaderText")
	private WebElement orginfo;

	@FindBy(className="dvtCellInfo")
	private WebElement orgboxname;

	public OrgInfoPageclass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getOrginfo() {
		return orginfo;
	}

	
	public WebElement getOrgboxname() {
		return orgboxname;
	}
	
	public void setorgverification()
	{
		String longorginfoname = orginfo.getText();	
		String orgBoxName=orgboxname.getText();
		if(longorginfoname.contains(orgBoxName))
		{
			System.out.println("verification successful"+orgBoxName);
		}
		
	}
	
}
