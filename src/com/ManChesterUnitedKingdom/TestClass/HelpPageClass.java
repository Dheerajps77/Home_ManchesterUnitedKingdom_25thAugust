package com.ManChesterUnitedKingdom.TestClass;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ManChesterUnitedKingdom.TestBase.TestBase;
import com.ManChesterUnitedKingdom.TestPages.HelpPage;
import com.ManChesterUnitedKingdom.utilities.CaptureScreenshot;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class HelpPageClass extends TestBase
{
	private static final Logger logger=Logger.getLogger(HelpPageClass.class.getSimpleName());
	HelpPage Obj_HelpPage;	
	WebDriverWait wait;
	

	@BeforeMethod
	public void CreateTest_HelpPage(Method name){
		
		e3=e2.createTest(this.getClass().getSimpleName() + " :: "+name.getName(), " has been started.");
	}
	
	@AfterMethod
	public void getResultHelpPage(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			e3.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName()+ " has been passed.", ExtentColor.GREEN));
			e3.log(Status.PASS, result.getName()+ "has been passed.");
		}
		if(result.getStatus()==ITestResult.FAILURE)
		{
			e3.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName()+ " has been failed", ExtentColor.RED));
			e3.log(Status.FAIL, result.getThrowable());
			e3.log(Status.FAIL, result.getName()+ " has been failed.");
			
			String capture=CaptureScreenshot.ScreenshotCapturing(driver, result.getMethod().getMethodName()+"_name");
			e3.addScreenCaptureFromPath(capture);
		}
		if(result.getStatus()==ITestResult.SKIP)
		{
			e3.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName() + " has been skipped.", ExtentColor.ORANGE));
			e3.log(Status.SKIP, result.getThrowable());
			e3.log(Status.SKIP, result.getName()+ " got skipped");
			throw new SkipException("This module has been skipped now..");
		}
		
	}
	
	@Test(priority=0,description="Action will be perform for HelpPage")
	public void Help() throws InterruptedException
	{
		logger.info("<========================Started of Help Page Test Secenario========================>");
		e3.info("This Module has been started now");
		logger.info("Called the InitElements method of PageFactory Class");
		Obj_HelpPage=PageFactory.initElements(driver, HelpPage.class);
		
		logger.info("Clicked on Help Link");
		Obj_HelpPage.Help_link();
		
		Thread.sleep(3000);
		
		logger.info("Scrolled down to the page");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		
		logger.info("Clicked on the contact Link");
		Obj_HelpPage.Contact_link();
	}
	
	@Test(priority=1)
	public void TitleOfPage_Verification()
	{	
		String currentTitle=Obj_HelpPage.VerifyTitleOfPage();
		e3.info("This Module has been started now");
		logger.info("Verified the title of the Help page");
		Assert.assertEquals(currentTitle, "Contact Us | Man Utd Phone Numbers & Email Addresses | Official Manchester United Website");
		//Assert.assertTrue(true, "Contact Us | Man Utd Phone Numbers & Email Addresses | Official Manchester United Website");
		
		logger.info("Print the title of the Help page");
		System.out.println("Current title of Page : "+currentTitle);
	}
	
	@Test(priority=2)
	public void TitleOfTicketSales() throws InterruptedException
	{
		
		String CurrentTitleofTicketSales=Obj_HelpPage.VerifyTicketSale_title();
		e3.info("This Module has been started now");
		logger.info("Verified the title of Ticket Sales");
		Assert.assertEquals(CurrentTitleofTicketSales, "Match ticket and Season Ticket sales and enquiries");
		//Assert.assertTrue(true, "Match ticket and Season Ticket sales and enquiries");

		logger.info("Print the title of Ticket Sales");
		System.out.println("Title of ticketSales : "+CurrentTitleofTicketSales);
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void Total_numberOfPhoneNumber()
	{
		logger.info("Stored all phone number values in List");
		e3.info("This Module has been started now");
		List<WebElement> textOfAllPhoneNumber=driver.findElements(By.xpath("//div[contains(@class,'contact-us__no')]//a"));
		
		int total_size=textOfAllPhoneNumber.size();
		
		logger.info("Got the total number of phone number");
		System.out.println("Total number of phone present in the Contact Us are as follow : "+total_size);
		System.out.println("===========================================================================");
		System.out.println("Below are the Phone Number which is present in Contact Us page");
		
		
		for(int i=0;i<total_size;i++)
		{
			String PrintAllNumber=textOfAllPhoneNumber.get(i).getText();
			System.out.println(PrintAllNumber);
		}	
		
	}
	
	@Test(priority=4)
	public void Total_numberOf_Title_OfPhoneNumber()
	{
		logger.info("Stored all titles in List");
		e3.info("This Module has been started now");
		List<WebElement> TitleOf=driver.findElements(By.xpath("//div[contains(@class,'contact-us__phone--list')]//p"));
		int total_size_ofTitle=TitleOf.size();
		
		logger.info("Got the total number of titles");
		System.out.println("Total number of Title for each phonumber in the Contact Us are as follow : "+total_size_ofTitle);
		System.out.println("===========================================================================");
		System.out.println("Below are all titles of Phone Number which is present in Contact Us page");
		
		for(int i=0;i<total_size_ofTitle;i++)
		{
			String PrintTitle=TitleOf.get(i).getText();
			System.out.println(PrintTitle);
	
		}
		logger.info("<========================End of Help Page Test Secenario========================>");

	}
	
	@Test(priority=5)
	public void FailedHelpPageModule(){
		e3.info("This Module has been started now");
		Assert.assertEquals(false, true);
	}
}

