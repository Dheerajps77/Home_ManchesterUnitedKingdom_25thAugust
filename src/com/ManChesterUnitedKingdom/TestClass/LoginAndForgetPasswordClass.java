package com.ManChesterUnitedKingdom.TestClass;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ManChesterUnitedKingdom.TestBase.TestBase;
import com.ManChesterUnitedKingdom.TestPages.LoginPage;
import com.ManChesterUnitedKingdom.utilities.CaptureScreenshot;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class LoginAndForgetPasswordClass extends TestBase{

	LoginPage Obj_Login;

	@Test(priority=0)
	public void Login() throws Throwable
	{
		e3.log(Status.INFO, "Login module has been started.");
		Obj_Login=PageFactory.initElements(driver, LoginPage.class);
		Obj_Login.LoginPag("testloginmanchester@yopmail.com", "Dheeraj@8");
		Thread.sleep(3000);	
	}
	
	@Test(dependsOnMethods={"Login"})
	public void LogOUt() throws InterruptedException
	{
		e3.log(Status.INFO, "Logout module has been started.");
		
		Obj_Login.LoginOut();
		
	}
	
	@Test(dependsOnMethods={"LogOUt"})
	public void ForgetPassword()throws InterruptedException
	{
		e3.log(Status.INFO, "ForgetPassword module has been started.");
		Obj_Login.ForgetPassword("testloginmanchester@yopmail.com", "testloginmanchester@yopmail.com","Dheeraj@10","Dheeraj@10");
		
	}
	
	@BeforeMethod
	public void SettingUpExtentReport(Method method)
	{
		e3=e2.createTest(this.getClass().getSimpleName() + " : : " + method.getName());
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			e3.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
			e3.log(Status.PASS, result.getMethod().getMethodName()+ " module has been passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			e3.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));
			e3.log(Status.FAIL, result.getThrowable());
			e3.log(Status.FAIL, result.getMethod().getMethodName()+ " module has been failed");
			String capture1=CaptureScreenshot.ScreenshotCapturing(driver, result.getMethod().getMethodName()+" name");
			e3.addScreenCaptureFromPath(capture1);
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			e3.log(Status.SKIP, result.getMethod().getMethodName()+ " module has been skipped");
			e3.log(Status.SKIP, result.getThrowable());
		}
	}
}
