package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageclass {
	@FindBy(name="user_name")
	private WebElement user_name_textbox;
	
	@FindBy(name="user_password")
	private WebElement pwd_text_box;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	public LoginPageclass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getUser_name_textbox() {
		return user_name_textbox;
	}

	
	public WebElement getPwd_text_box() {
		return pwd_text_box;
	}

	
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void setLogin(String username, String password) 
	{
		user_name_textbox.sendKeys(username);
		pwd_text_box.sendKeys(password);
		loginbtn.click();
	}
	

}
