package com.ManChesterUnitedKingdom.TestClass;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ManChesterUnitedKingdom.TestBase.TestBase;
import com.ManChesterUnitedKingdom.TestPages.LanguageDropdownHomePage;
import com.ManChesterUnitedKingdom.utilities.CaptureScreenshot;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class LanguageDropdownHomePageClass extends TestBase
{
	
	LanguageDropdownHomePage Ob_LanguageDropdownHomePage;
	
	
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
			String capture=CaptureScreenshot.ScreenshotCapturing(driver,result.getMethod().getMethodName()+" MouseHover");
			e3.addScreenCaptureFromPath(capture);
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			e3.log(Status.SKIP, result.getMethod().getMethodName()+ " module has been skipped");
			e3.log(Status.SKIP, result.getThrowable());
		}
	}
	
	@Test
	public void HovringToLanguage()
	{
		e3.log(Status.INFO, "HovringToLanguage module has been started now..");
		Ob_LanguageDropdownHomePage=PageFactory.initElements(driver, LanguageDropdownHomePage.class);
		Ob_LanguageDropdownHomePage.HovringToEnglishLanguage();
	}
	
	@Test(dependsOnMethods="HovringToLanguage")
	public void Language_Collection()
	{
		e3.log(Status.INFO, "Language_Collection module has been started now..");
		Ob_LanguageDropdownHomePage.CollectingAllLanguagePresentText();
	}
	
	@Test(dependsOnMethods="Language_Collection")
	public void ClickingOnESPAÑOL() throws InterruptedException
	{
		e3.log(Status.INFO, "ClickingOnESPAÑOL module has been started now..");
		Ob_LanguageDropdownHomePage.ClickOnESPAÑOL();
	}
	
	@Test(dependsOnMethods="ClickingOnESPAÑOL")
	public void SkippingDemoMethod()
	{
		e3.log(Status.INFO, "SkippingDemoMethod module has been started now..");
		throw new SkipException("Skipping this one as this is not ready for test..");
	}
	
}
