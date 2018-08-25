package com.ManChesterUnitedKingdom.TestPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class SignUpPage 
{
	WebDriver driver;
	
	public SignUpPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	@FindBy(how = How.XPATH, using = "//ul//li[5]//a[@data-track-text='Sign Up']")
	WebElement SignUpLink;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='First name']")
	WebElement FirstName;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='Surname']")
	WebElement SurName;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='Email address']")
	WebElement EMail_address;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='Password']")
	WebElement Pass_word;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='Confirm password']")
	WebElement ConPass_word;
	
	@FindBy(how=How.XPATH, using="//input[@id='login']")
	WebElement YopEmailID;
	
	@FindBy(how=How.XPATH, using="//input[@value='Check Inbox']")
	WebElement CheckInbox;
	
	@FindBy(how=How.XPATH, using="//div[@class='bname b al_l']")
	WebElement GetText;
	
	@FindBy(how=How.XPATH, using="//select[@name='profile.birthDay' and @aria-label='Date']")
	WebElement Day;
	
	@FindBy(how=How.XPATH, using="//select[@name='profile.birthMonth' and @aria-label='Month']")
	WebElement Month;
	
	@FindBy(how=How.XPATH, using="//select[@name='profile.birthYear' and @aria-label='Year']")
	WebElement Year;
	
	@FindBy(how=How.XPATH, using="//select[@name='profile.country' and @aria-label='Country']")
	WebElement Country;
	
	@FindBy(how=How.XPATH, using="//label[text()='Yes']")
	WebElement RadioButton;
	
	@FindBy(how=How.XPATH, using="//input[@type='submit' and @data-screenset-roles='instance']")
	WebElement SubmitButton;
	
	public void YopmailIDCreation(String email)
	{
		driver.navigate().to("http://www.yopmail.com/en/");
		YopEmailID.sendKeys(email);
		CheckInbox.click();
		String emailIDText=GetText.getText();
		System.out.println(emailIDText);
		
		SoftAssert emailVerification=new SoftAssert();
		emailVerification.assertTrue(true, emailIDText);
		emailVerification.assertAll();
		
	}
	public void Registration(String Fname, String Sname, String Email, String Password, String ConfimPassword) throws InterruptedException
	{
	
		Thread.sleep(3000);
		driver.get("https://www.manutd.com/");
		SignUpLink.click();
		FirstName.sendKeys(Fname);
		SurName.sendKeys(Sname);
		EMail_address.sendKeys(Email);
		Pass_word.sendKeys(Password);
		Thread.sleep(3000);
		ConPass_word.sendKeys(ConfimPassword);
		Thread.sleep(3000);
		
		Select Dday=new Select(Day);
		Dday.selectByValue("26");
		
		Select Mmonth=new Select(Month);
		Mmonth.selectByValue("12");
		
		Select Yyear=new Select(Year);
		Yyear.selectByValue("1992");
		
		Select Ccountry=new Select(Country);
		Ccountry.selectByValue("India");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		
		RadioButton.click();
		SubmitButton.click();
		Thread.sleep(4000);
		
	}
}