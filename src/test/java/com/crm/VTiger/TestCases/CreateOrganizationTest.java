package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;

import genericLirbrary.BaseClass;
import genericLirbrary.ExcelUtility;
import genericLirbrary.JavaUtility;
import objectRepo.ContactPage;
import objectRepo.CreateOrganizationPageclass;
import objectRepo.HomePageclass;
import objectRepo.OrgInfoPageclass;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public  void test1() throws Throwable
	{
		ExcelUtility eutil=new ExcelUtility();
		String orgname=eutil.readDatafromExcel("Sheet1", 1, 1)+JavaUtility.generateRandomNumber();
		HomePageclass hp=new HomePageclass(driver);
		
		hp.getOrgbutton().click();
		ContactPage cp=new ContactPage(driver);
		
		cp.getPlussymbl().click();
		CreateOrganizationPageclass cop=new CreateOrganizationPageclass(driver);
		
		cop.setaccsave(orgname);
		OrgInfoPageclass oip=new OrgInfoPageclass(driver);
		oip.setorgverification();	

	}

}
