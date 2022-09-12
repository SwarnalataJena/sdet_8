package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;

public class DemoFlag {
	
	@Test
	public void orgTest()
	{
		System.out.println("organization is created");	
	}

	@Test(invocationCount = 5)
	public void contactTest()
	{

		System.out.println("contact is created");
		
	}

	@Test(enabled = false)
	public void purchaseTest()
	{
		System.out.println("purchase order is created");
//		int a=5/0;
//		System.out.println(a);
	}

}
