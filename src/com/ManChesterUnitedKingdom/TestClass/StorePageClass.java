package com.ManChesterUnitedKingdom.TestClass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ManChesterUnitedKingdom.TestBase.TestBase;
import com.ManChesterUnitedKingdom.TestPages.StorePage;

public class StorePageClass extends TestBase

{
	StorePage Obj_StorePage;
	
	
	@Test(priority=0)
	public void StoreFlow() throws InterruptedException
	{
		Obj_StorePage=PageFactory.initElements(driver, StorePage.class);
		Obj_StorePage.StoreLink();
	}
	
	@Test(priority=1)
	public void MenModule() throws InterruptedException
	{
		Obj_StorePage.Men();
	}
}
