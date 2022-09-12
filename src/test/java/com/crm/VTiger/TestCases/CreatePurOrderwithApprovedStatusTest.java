package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;

import genericLirbrary.BaseClass;
import genericLirbrary.ExcelUtility2;
import objectRepo.CreatePurchaseOrderPage;
import objectRepo.HomePageclass;
import objectRepo.PurchaseOrderPage;

public class CreatePurOrderwithApprovedStatusTest extends BaseClass{
	@Test
	public void test5() throws Throwable
	{
		HomePageclass hpc=new HomePageclass(driver);
		hpc.setPurOrder(driver);
		
		PurchaseOrderPage p=new PurchaseOrderPage(driver);
		p.getCreate_purorder().click();
		
		CreatePurchaseOrderPage cpo=new CreatePurchaseOrderPage(driver);
		ExcelUtility2 xu=new ExcelUtility2();
		String stus=xu.readDatafromExcel2("Sheet1", 10, 1);
		cpo.setStatus(stus);
	}

}
