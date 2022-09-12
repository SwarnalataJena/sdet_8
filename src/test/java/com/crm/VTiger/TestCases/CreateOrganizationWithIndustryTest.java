package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;

import genericLirbrary.BaseClass;
import genericLirbrary.ExcelUtility;
import genericLirbrary.JavaUtility;
import objectRepo.CreateOrganizationPageclass;
import objectRepo.HomePageclass;
import objectRepo.OrgInfoPageclass;
import objectRepo.Orgpageclass;

public class CreateOrganizationWithIndustryTest extends BaseClass{
	@Test
	public void testcase2() throws Throwable
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
