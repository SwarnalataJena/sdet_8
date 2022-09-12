package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage {
	@FindBy(className="dvHeaderText")
	private WebElement contactinfo_name;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastname_info;
	
	

}
