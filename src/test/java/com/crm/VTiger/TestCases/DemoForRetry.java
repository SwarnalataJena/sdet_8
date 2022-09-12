package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;

import genericLirbrary.BaseClass;

public class DemoForRetry extends BaseClass{
	@Test(retryAnalyzer = genericLirbrary.RetryAnalyserClass.class)
	public void retryTest()
	{
		System.out.println("main starts");
		int a=10;
		int b=0;
		int c=a/b;
		System.out.println(c);
	}

}
