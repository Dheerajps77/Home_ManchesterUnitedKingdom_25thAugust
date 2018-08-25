package com.ManChesterUnitedKingdom.TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.*;

public class All_MatchesPage 
{
WebDriver driver;
	
	public All_MatchesPage(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	@FindBy(how=How.XPATH, using="//a[@data-track-text='All matches']")
	WebElement AllMatch_link;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$client1$txtEMail']")
	WebElement txtEMail;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$client1$txtPassword']")
	WebElement txtPassword;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$client1$txtPasswordConfirm']")
	WebElement txtPasswordConfirm;
	
	@FindBy(how=How.XPATH, using="//select[@name='ctl00$body$logincontainer1$login1$client1$listTitles']")
	WebElement listTitles;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$client1$txtForename']")
	WebElement txtForename;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$client1$txtSurname']")
	WebElement txtSurname;
	
	@FindBy(how=How.XPATH, using="//select[@id='ctl00_body_logincontainer1_login1_client1_dateDOB_lD']")
	WebElement _dateDOB_lD;
	
	@FindBy(how=How.XPATH, using="//select[@id='ctl00_body_logincontainer1_login1_client1_dateDOB_lM']")
	WebElement _dateDOB_lM;
	
	@FindBy(how=How.XPATH, using="//select[@id='ctl00_body_logincontainer1_login1_client1_dateDOB_mY']")
	WebElement _dateDOB_mY;
	
	@FindBy(how=How.XPATH, using="//select[@id='ctl00_body_logincontainer1_login1_client1_address1_listCountry']")
	WebElement address1_listCountry;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$client1$address1$txtLine1']")
	WebElement address1$txtLine1;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$client1$address1$txtTown']")
	WebElement address1$txtTown;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$client1$address1$txtPostcode']")
	WebElement address1$txtPostcode;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$client1$telephoneMobile$txtTelephone']")
	WebElement telephoneMobile$txtTelephone;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_body_logincontainer1_login1_client1_checkDPAPost']")
	WebElement checkDPAPost;
	
	@FindBy(how=How.XPATH, using="//span[@id='Anthem_ctl00_body_logincontainer1_login1_cmdRegister__']")
	WebElement cmdRegister;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$txtPrimary']")
	WebElement txtPrimary;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$txtSecondary']")
	WebElement txtSecondary;
	
	@FindBy(how=How.XPATH, using="//input[@name='ctl00$body$logincontainer1$login1$cmdLogin']")
	WebElement cmdLogin;
	
	@FindBy(how=How.XPATH, using="//ul[@id='errorsummary']//li//a")
	WebElement Error_details;
	
	@FindBy(how=How.XPATH, using="//span[@id='Anthem_ctl00_body_logincontainer1_login1_cmdShowRegister__']")
	WebElement Register__;
	
	
	public void AllMatches() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		AllMatch_link.click();
		System.out.println("=================================");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
	}
	
	public void MembershipLogin() throws InterruptedException
	{
		txtPrimary.sendKeys("Dheerajps23423@gmail.com");
		txtSecondary.sendKeys("India@123");
		cmdLogin.click();
		
		Thread.sleep(2000);
		System.out.println(Error_details.getText());
		
		System.out.println("================================================");
		SoftAssert ErrorMesg=new SoftAssert();
		String Expected_ErrorMesg=Error_details.getText();
		
		String expected="The Membership number you have entered is not valid, please check and try again";
		Assert.assertEquals(Expected_ErrorMesg, expected, "Error messages has been verified .... ");
		ErrorMesg.assertAll();
		System.out.println("Test Error message for login Module has been passed....");
	}
	
	public void AccountCreation() throws InterruptedException
	{
		Register__.click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		
		txtEMail.sendKeys("Dheerajps56677@yopmail.com");
		txtPassword.sendKeys("India@123");
		txtPasswordConfirm.sendKeys("India@123");
		
		Select dropdown_Titles=new Select(listTitles);
		//listTitles.click();
		//listTitles.submit();
		dropdown_Titles.selectByValue("Mr");
		Thread.sleep(3000);
		txtForename.sendKeys("Dheeraj Pratap");
		txtSurname.sendKeys("Singh");
		
		Select Dropdown_dateDOB_lD=new Select(_dateDOB_lD);
		Dropdown_dateDOB_lD.selectByValue("26");
		
		Select Dropdown_dateDOB_lM=new Select(_dateDOB_lM);
		Dropdown_dateDOB_lM.selectByValue("12");
		
		Select Dropdown_dateDOB_mY=new Select(_dateDOB_mY);
		Dropdown_dateDOB_mY.selectByValue("1992");
		
		Thread.sleep(3000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,450)");
		
		
		Select Dropdown_address1_listCountry=new Select(address1_listCountry);
		Dropdown_address1_listCountry.selectByValue("99");
		
		address1$txtLine1.sendKeys("Hudson house-12");
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		
		address1$txtTown.sendKeys("New Delhi");
		address1$txtPostcode.sendKeys("110048");
		telephoneMobile$txtTelephone.sendKeys("7189371992");
		checkDPAPost.click();
		
		cmdRegister.click();
		
		System.out.println("-------------------------------------------------------");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
	}

}
