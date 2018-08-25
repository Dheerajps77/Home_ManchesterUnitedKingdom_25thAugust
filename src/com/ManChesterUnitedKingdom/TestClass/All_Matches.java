package com.ManChesterUnitedKingdom.TestClass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ManChesterUnitedKingdom.TestBase.TestBase;
import com.ManChesterUnitedKingdom.TestPages.All_MatchesPage;

public class All_Matches extends TestBase
{
	All_MatchesPage Obj_MatchesPage;
	
	@Test(priority=0)
	public void AllMatch() throws InterruptedException
	{
		Obj_MatchesPage=PageFactory.initElements(driver, All_MatchesPage.class);
		Obj_MatchesPage.AllMatches();
		
	}
	
	@Test(priority=1)
	public void Login()throws InterruptedException
	{
		Obj_MatchesPage.MembershipLogin();
	}
	
	@Test(priority=2) 
	public void AccountRegistration()throws InterruptedException
	{
		Obj_MatchesPage.AccountCreation();
	}

}