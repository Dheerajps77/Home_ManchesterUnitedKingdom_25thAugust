package com.ManChesterUnitedKingdom.TestClass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ManChesterUnitedKingdom.TestBase.TestBase;
import com.ManChesterUnitedKingdom.TestPages.SignUpPage;
import com.ManChesterUnitedKingdom.utilities.CaptureScreenshot;

public class SignUpPageClass extends TestBase
{
	SignUpPage Obj_register;
	
	@Test(priority=0)
	public void YopmailIDCreation()
	{
		Obj_register = PageFactory.initElements(driver, SignUpPage.class);
		Obj_register.YopmailIDCreation("MUKRegistration");
	
	}
	@Test(priority=1)
	public void ManchesterUnitedKingdomegister() throws Exception 
	{		
		String s1="RegistrationSignUp";
		Obj_register.Registration("Dheeraj", "Singh", "MUKRegistration@yopmail.com", "Password@1", "Password@1");
		CaptureScreenshot.ScreenshotCapturing(driver, "RegisrationPage");
	}
}