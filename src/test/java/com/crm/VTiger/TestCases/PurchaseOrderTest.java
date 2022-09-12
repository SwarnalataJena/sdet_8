package com.crm.VTiger.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLirbrary.BaseClass;
import genericLirbrary.ExcelUtility2;
import genericLirbrary.WebDriverUtility;
import objectRepo.CreatePurchaseOrderPage;
import objectRepo.HomePageclass;
import objectRepo.PurchaseOrderPage;
import objectRepo.VenderNameSearch;
@Listeners(genericLirbrary.ListenerImp.class)
public class PurchaseOrderTest extends BaseClass{
  	@Test(groups = "regression")
	
	public void withoutItems() throws Throwable
	{
		HomePageclass hpc=new HomePageclass(driver);
		hpc.setPurOrder(driver);
		
		PurchaseOrderPage p=new PurchaseOrderPage(driver);
		p.getCreate_purorder().click();
		
		ExcelUtility2 xu=new ExcelUtility2();
		String Sub=xu.readDatafromExcel2("Sheet1", 1, 1);
		String Vname=xu.readDatafromExcel2("Sheet1", 2, 1);
		String stat=xu.readDatafromExcel2("Sheet1", 3, 1);
		String Badd=xu.readDatafromExcel2("Sheet1", 4, 1);
		String Sadd=xu.readDatafromExcel2("Sheet1", 5, 1);

		WebDriverUtility wUtil=new WebDriverUtility();
		CreatePurchaseOrderPage cpo=new CreatePurchaseOrderPage(driver);
		cpo.setSub_Vname(Sub);
		wUtil.switchingwindow(driver, "Vendors");
		VenderNameSearch vns=new VenderNameSearch(driver);
		vns.setvender(Vname);
		
		wUtil.switchingwindow(driver, "PurchaseOrder");
		
		cpo.setPurch_exceptItem(stat, Badd,Sadd);
		
		wUtil.handleAlt(driver);
		
	}
//    @Test(groups = "smoke")
//	
//	public void statusApproved() throws Throwable
//	{
//		HomePageclass hpc=new HomePageclass(driver);
//		hpc.setPurOrder(driver);
//		
//		PurchaseOrderPage p=new PurchaseOrderPage(driver);
//		p.getCreate_purorder().click();
//		
//		CreatePurchaseOrderPage cpo=new CreatePurchaseOrderPage(driver);
//		ExcelUtility2 xu=new ExcelUtility2();
//		String stus=xu.readDatafromExcel2("Sheet1", 10, 1);
//		cpo.setStatus(stus);
//		
//	}
}
