package practiseTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericLirbrary.BaseClass;
import genericLirbrary.ExcelUtility2;
import genericLirbrary.PropertyFileUtility;
import genericLirbrary.WebDriverUtility;
import objectRepo.CreatePurchaseOrderPage;
import objectRepo.HomePageclass;
import objectRepo.LoginPageclass;
import objectRepo.ProductPage;
import objectRepo.PurchaseOrderPage;
import objectRepo.VenderNameSearch;

public class PurchaseOrderTestCases1 extends BaseClass{
	@Test
	public void test1() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wUtil=new WebDriverUtility();
		wUtil.windowMaximize(driver);
		wUtil.impwait(driver);
		
		PropertyFileUtility p=new PropertyFileUtility();
		String Url = p.readDataFromPropertyFile("url");
		String Un = p.readDataFromPropertyFile("un");
		String Pwd = p.readDataFromPropertyFile("pwd");
		driver.get(Url);
		
		LoginPageclass lp=new LoginPageclass(driver);
		lp.setLogin(Un, Pwd);
		
		HomePageclass hp=new HomePageclass(driver);
		hp.setPurOrder(driver);
		
		PurchaseOrderPage po=new PurchaseOrderPage(driver);
		po.getCreate_purorder().click();
		
		ExcelUtility2 ex=new ExcelUtility2();
		String sub = ex.readDatafromExcel2("Sheet1",1 ,1 );
		String staus = ex.readDatafromExcel2("Sheet1",3 ,1 );
		String Badd = ex.readDatafromExcel2("Sheet1",4 ,1 );
		String Sadd = ex.readDatafromExcel2("Sheet1",5 ,1 );
		String item = ex.readDatafromExcel2("Sheet1",6 ,1 );
		
		CreatePurchaseOrderPage cpo=new CreatePurchaseOrderPage(driver);
		cpo.setSub_Vname(sub);
		
		wUtil.switchingwindow(driver, "Vendors");
		
		VenderNameSearch vs=new VenderNameSearch(driver);
		vs.setvender("Prakash");
		
		wUtil.switchingwindow(driver, "PurchaseOrder");
		
		cpo.setPurch_exceptItem(staus, Badd, Sadd);
		cpo.getProduct_plus().click();
		
		wUtil.switchingwindow(driver, "Products");
		
		ProductPage pp=new ProductPage(driver);
		pp.setProductSearchBox(item);		
		wUtil.switchingwindow(driver, "PurchaseOrder");
		
		cpo.getQty().sendKeys("3");
		cpo.getSave_btn().click();
		hp.setLogout(driver);
		
	}

}
