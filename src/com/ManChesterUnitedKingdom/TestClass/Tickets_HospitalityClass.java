package com.ManChesterUnitedKingdom.TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ManChesterUnitedKingdom.TestBase.TestBase;
import com.ManChesterUnitedKingdom.TestPages.Tickets_HospitalityPage;

public class Tickets_HospitalityClass extends TestBase
{
	Tickets_HospitalityPage ObjTickets_Hospitality;
	
	@Test(priority=0)
	public void Match_ticketsFlow() throws InterruptedException
	{
		ObjTickets_Hospitality=PageFactory.initElements(driver, Tickets_HospitalityPage.class);
		ObjTickets_Hospitality.click_Tickets_Hospitality_link();
		ObjTickets_Hospitality.Tour_Tickets_2018();
	}
	
	@Test(priority=1, enabled=false)
	public void Tour_Tickets() throws InterruptedException{
		
		ObjTickets_Hospitality.Tour_Tickets_2018();
	}

	@Test(priority=2)
	public void ClubAmerica()throws InterruptedException
	{
		
		ObjTickets_Hospitality.Club_America();
	}
}