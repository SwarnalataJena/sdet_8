package com.crm.VTiger.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoBaseClass {
	@BeforeSuite
	public void connDB()
	{
		System.out.println("DB connected successfully");
	}

	@BeforeTest
	public void crossBrowser()
	{
		System.out.println("cross browser started");
	}

	@BeforeClass
	public void openBrowser()
	{
		System.out.println("browser opened");
	}

	@BeforeMethod
	public void login()
	{
		System.out.println("Login done");
	}

	@Test(priority = 2)
	public void createContact()
	{
		System.out.println("contact created");
	}

	@Test(priority = 1)
	public void createPurchaseOrder()
	{
		System.out.println("purchase order created");
	}

	@AfterMethod
	public void logout()
	{
		System.out.println("logout done");
	}

	@AfterClass
	public void closeBrowser()
	{
		System.out.println("browser closed");
	}

	@AfterTest
	public void crossBrowserdone()
	{
		System.out.println("cross browser done");
	}

	@AfterSuite
	public void closeConn()
	{
		System.out.println("Connection closed successfully");
	}

}
