package com.ManChesterUnitedKingdom.TestClass;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.ManChesterUnitedKingdom.TestBase.TestBase;
import com.ManChesterUnitedKingdom.TestPages.FixturesPage;
import com.ManChesterUnitedKingdom.utilities.CaptureScreenshot;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class FixturesPageClass extends TestBase
{
	FixturesPage Obj_FixturesPage;
	private static final Logger logger=Logger.getLogger(FixturesPageClass.class.getSimpleName());
	
	@BeforeMethod
	public void CreatingTestExtentReport(Method name)
	{
		e3=e2.createTest(this.getClass().getSimpleName() + " :: "+ name.getName(), "has been started");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			//e3.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test case has been passed for this module", ExtentColor.GREEN));
			e3.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
			e3.log(Status.PASS, result.getName()+ " has been passed");
		}
		if(result.getStatus()==ITestResult.FAILURE)
			
		{
			//e3.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test case has been failed for this module", ExtentColor.RED));
			e3.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));
			e3.log(Status.FAIL, result.getThrowable());
			e3.log(Status.FAIL, result.getName()+" has been failed.");
			logger.info("Captured the screenshot for the failed test case in seperate file");
			String capture=CaptureScreenshot.ScreenshotCapturing(driver, result.getName() + "_name");
			logger.info("Captured the screenshot for the failed test case in ExtentReport");
					e3.addScreenCaptureFromPath(capture);
		}
		if(result.getStatus()==ITestResult.SKIP)
		{
			e3.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test case has been skipped for while now", ExtentColor.ORANGE));
			e3.log(Status.SKIP, result.getThrowable());
			e3.log(Status.SKIP, result.getName()+ " has been skipped for as of now...");
			throw new SkipException("Skipping this method as this is not ready for now..");
		}
	}
	
	@Test(priority=0)
	public void FixtureLinkModule() throws InterruptedException
	{
		logger.info("<========================Started of Fixture Page Test Secenario========================>");
		
		e3.log(Status.INFO, "This module has been started");
		Obj_FixturesPage=PageFactory.initElements(driver, FixturesPage.class);
		Obj_FixturesPage.FixtureModule();	
		Thread.sleep(5000);
		
		logger.info("Got the title of the current page");
		System.out.println("parent Window is "+driver.getTitle());
		
		logger.info("Got the total number of windows currently");
		Set<String> Child_window=driver.getWindowHandles();
		
		logger.info("Stored the child windows and total child window currently 3");
		ArrayList<String> tabs=new ArrayList<>(Child_window);
		tabs.get(0);
		tabs.get(1);
		//tabs.get(2);
		
		logger.info("Went to the parent window and closed the window");
		Thread.sleep(3000);
		driver.switchTo().window(tabs.get(0)).close();
		
		Thread.sleep(2000);
		logger.info("Went to the 1st Child window and closed the window");
		//driver.switchTo().window(tabs.get(1)).close();
		//Thread.sleep(3000);
		
		logger.info("Went to the 2nd child window");
		driver.switchTo().window(tabs.get(1));
		
		logger.info("Got the title of 2nd child window");
		System.out.println("Title of : "+driver.getTitle());
		Thread.sleep(300);
	}
	
	@Test(priority=1)
	public void CalenderForm() throws InterruptedException
	{
		logger.info("Entered the value in the Calender forms");
		e3.log(Status.INFO, "This module has been started");
		Obj_FixturesPage.Calender_Form("Dheeraj", "Singh", "DheerajPratapSingh@hcl.com");
	}
	
	@Test(priority=2)
	public void Verification_Google_Calender_title() throws InterruptedException
	{
		logger.info("Verified the title of the google calender");
		e3.log(Status.INFO, "This module has been started");
		Obj_FixturesPage.Google_CalenderVerify();
	}
	
	@Test(priority=3)
	public void FailingModule(){
		logger.info("FailingModule has been tested");
		e3.log(Status.INFO, "This module has been started");
		Assert.assertEquals(false, true);
		
	}
	
	@Test(priority=4)
	public void SkippingModule(){
		e3.log(Status.INFO, "This module has been started");
		logger.info("SkippingModule has been tested");
		System.out.println("Skipping this one");
		logger.info("<========================Ended of Fixture Page Test Secenario========================>");
	}
}
