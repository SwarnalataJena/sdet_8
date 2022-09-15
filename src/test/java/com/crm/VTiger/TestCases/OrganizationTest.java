package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;

import genericLirbrary.BaseClass;
import genericLirbrary.ExcelUtility;
import genericLirbrary.JavaUtility;
import objectRepo.ContactPage;
import objectRepo.CreateOrganizationPageclass;
import objectRepo.HomePageclass;
import objectRepo.OrgInfoPageclass;
import objectRepo.Orgpageclass;

public class OrganizationTest extends BaseClass{
	@Test
	public void createOrg() throws Throwable
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
		@Test
		public void createOrgWithIndus() throws Throwable
		{
			ExcelUtility eutil=new ExcelUtility();
			String orgname=eutil.readDatafromExcel("Sheet1", 4, 1)+JavaUtility.generateRandomNumber();
			String indstname=eutil.readDatafromExcel("Sheet1", 4, 2);

			HomePageclass hp=new HomePageclass(driver);
			hp.getOrgbutton().click();

			Orgpageclass opc=new Orgpageclass(driver);
			opc.setcreateorgplus();

			CreateOrganizationPageclass cop=new CreateOrganizationPageclass(driver);
			cop.setaccindsave(orgname, indstname);

			OrgInfoPageclass or=new OrgInfoPageclass(driver);
			or.setorgverification();
		}
		
	
}
