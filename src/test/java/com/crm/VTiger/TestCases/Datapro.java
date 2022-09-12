package com.crm.VTiger.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datapro {
	@Test(dataProvider = "provideData")
	public void gettingData(String name, int id)
	{
		System.out.println("Name is "+name+" id is "+id);
	}
	@DataProvider
	public Object[][] provideData()
	{
		Object obj[][]=new Object[3][2];
		obj[0][0]="Akash";
		obj[0][1]=101;

		obj[1][0]="Amear";
		obj[1][1]=102;

		obj[2][0]="Swarna";
		obj[2][1]=103;

		return obj;
	}

}
