package com.ManChesterUnitedKingdom.TestClass;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ManChesterUnitedKingdom.TestBase.TestBase;
import com.ManChesterUnitedKingdom.TestPages.United_vs_TottenhamInHomePage;
import com.ManChesterUnitedKingdom.utilities.CaptureScreenshot;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class United_vs_TottenhamInHomePageClass extends TestBase
{
	
	United_vs_TottenhamInHomePage Obj_RegisterYourInterestPage;
	
	@BeforeMethod
	public void SettingUpExtentReportForLanguageDropdownHome(Method method)
	{
	
		e3=e2.createTest(this.getClass().getSimpleName() + " : : "+method.getName() + " module has been started now..");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			e3.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
			e3.log(Status.PASS, result.getMethod().getMethodName()+" module has been passed successfully...");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			e3.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));
			e3.log(Status.FAIL, result.getThrowable());
			e3.log(Status.FAIL, result.getMethod().getMethodName()+ " module has been failed");
			String capture=CaptureScreenshot.ScreenshotCapturing(driver,"MouseHover");
			e3.addScreenCaptureFromPath(capture);
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			e3.log(Status.SKIP, result.getMethod().getMethodName()+ " module has been skipped");
			e3.log(Status.SKIP, result.getThrowable());
		}
	}
	
	@Test
	public void ClickOnResgisterInterestModule() throws InterruptedException
	{
		Obj_RegisterYourInterestPage=PageFactory.initElements(driver, United_vs_TottenhamInHomePage.class);
		Obj_RegisterYourInterestPage.ClickOnUnited_vs_TottenhamImage();
		Obj_RegisterYourInterestPage.TitleAndUrlOfCurrentPage();
	}

}
