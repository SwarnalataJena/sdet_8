package com.crm.VTiger.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLirbrary.BaseClass;
import genericLirbrary.ExcelUtility;
import objectRepo.ContactPage;
import objectRepo.CreateContactPage;
import objectRepo.HomePageclass;
import objectRepo.SearchOrgpage;
@Listeners(genericLirbrary.ListenerImp.class)
public class CreateContactWithOrgTest extends BaseClass{
	@Test
	public void contactWithOrg() throws Throwable
	{
		ExcelUtility exeutil=new ExcelUtility();
		String mmr=exeutil.readDatafromExcel("Sheet1", 7, 1);
		String fname=exeutil.readDatafromExcel("Sheet1",7,2);
		String lname=exeutil.readDatafromExcel("Sheet1", 7, 3);
		String orgName=exeutil.readDatafromExcel("Sheet1", 10, 1);
		
		
		HomePageclass hp=new HomePageclass(driver);
//		click method is missing
		hp.getCntactbutton();
		
		ContactPage cp=new ContactPage(driver);
		cp.getPlussymbl().click();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.setMrFiLa(mmr, fname, lname);
		
		wutil.switchingwindow(driver, "Accounts");
		SearchOrgpage sop=new SearchOrgpage(driver);
		sop.setOrgname(orgName);
		
		wutil.switchingwindow(driver, "Contacts");
		
		ccp.getSavebutton().click();	
	}

}
