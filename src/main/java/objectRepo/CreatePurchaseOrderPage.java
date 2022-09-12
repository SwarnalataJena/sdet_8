package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLirbrary.WebDriverUtility;

public class CreatePurchaseOrderPage {
	WebDriverUtility wUtil=new WebDriverUtility();
	@FindBy(id="productName1")
	private WebElement pro_name;

		@FindBy(id="qty1")
		private WebElement qty;
	//	
	//	@FindBy(id="listPrice1")
	//	private WebElement list_price;
//	@FindBy(id="productName1")
//	private WebElement pname;

	@FindBy(name="button")
	private WebElement save_btn;

	@FindBy(name="subject")
	private WebElement sub;

	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement vname;

	@FindBy(name="postatus")
	private WebElement status;

	@FindBy(name="bill_street")
	private WebElement bill_add;

	@FindBy(name="ship_street")
	private WebElement ship_add;
	
	@FindBy(id="searchIcon1")
	private WebElement product_plus;
	

	public CreatePurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getQty() {
		return qty;
	}

	public WebElement getProduct_plus() {
		return product_plus;
	}

	public WebElement getSave_btn() {
		return save_btn;
	}

	public WebElement getSub()
	{
		return sub;
	}
	public WebElement getVname()
	{
		return vname;
	}
	public WebElement getStatus()
	{
		return status;
	}
	public WebElement getBill_add()
	{
		return bill_add;
	}
	public WebElement getShip_add()
	{
		return ship_add;
	}

	public void setSub_Vname(String sbjct)
	{
		sub.sendKeys(sbjct);
		vname.click();

	}
	public void setPurch_exceptItem(String status_name,String b_add, String s_add)
	{

		wUtil.selectingByVisibleText(status, status_name);
		bill_add.sendKeys(b_add);
		ship_add.sendKeys(s_add);
		save_btn.click();
	}
	public void setStatus(String statusName)
	{
		wUtil.selectingByValue(status,statusName);
	}
	

	


}
