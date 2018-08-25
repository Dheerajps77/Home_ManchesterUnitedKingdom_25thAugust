package com.ManChesterUnitedKingdom.TestPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.ManChesterUnitedKingdom.TestClass.HelpPageClass;

public class FixturesPage 
{
	WebDriver driver;
	Actions action;
	
	private static final Logger logger=Logger.getLogger(HelpPageClass.class.getSimpleName());
	
	public FixturesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//span[text()='Fixtures' and @class='web']")
	WebElement Fixture_link;
	
	@FindBy(how=How.XPATH, using="//a[@data-track-text='Fixtures Calendar']")
	WebElement Fixture_Calender_link;
	
	@FindBy(how=How.XPATH, using="//input[@id='firstname-control']")
	WebElement Fname;
	
	@FindBy(how=How.XPATH, using="//input[@id='lastname-control']")
	WebElement Lname;
	
	@FindBy(how=How.XPATH, using="//input[@id='email-control']")
	WebElement email;
	
	@FindBy(how=How.XPATH, using="//select[@id='select-control']")
	WebElement TimeZone;
	
	@FindBy(how=How.XPATH, using="//select[@id='select-control-day']")
	WebElement DDay;
	
	@FindBy(how=How.XPATH, using="//select[@id='select-control-month']")
	WebElement Mmonth;
	
	@FindBy(how=How.XPATH, using="//select[@id='select-control-year']")
	WebElement Yyear;
	
	@FindBy(how=How.XPATH, using="//label[@for='no-preference']")
	WebElement RadioButton;
	
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(how=How.XPATH, using="//div[@id='add-googlecalendar']")
	WebElement Google_Calender;
	
	public void FixtureModule() throws InterruptedException
	{
		logger.info("Hover the mouse cursor to the Fixture in the Menu.");
		action=new Actions(driver);
		action.moveToElement(Fixture_link).build().perform();
		Thread.sleep(3000);
		
		logger.info("Clicked on the Calender Link.");
		Fixture_Calender_link.click();
	}
	
	public void Calender_Form(String FirstName, String LastName, String EmailID) throws InterruptedException
	{
		logger.info("Entered the first Name in the textfield");
		Fname.sendKeys(FirstName);
		
		logger.info("Entered the Last Name in the textfield");
		Lname.sendKeys(LastName);
		
		logger.info("Entered the Email ID in the textfield");
		email.sendKeys(EmailID);
		Thread.sleep(3000);
		
		logger.info("Scrolled down to the page");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		logger.info("Clicked on the TimeZone");
		TimeZone.click();
		Select timezone=new Select(TimeZone);
		
		
		timezone.selectByVisibleText("India");
		
		logger.info("Selected the Day value");
		DDay.click();
		Select BDate=new Select(DDay);
		BDate.selectByVisibleText("26");
		
		logger.info("Selected the Month value");
		Mmonth.click();
		Select BMonth=new Select(Mmonth);
		BMonth.selectByVisibleText("Dec");
		
		logger.info("Selected the Year value");
		Yyear.click();
		Select BYear=new Select(Yyear);
		BYear.selectByVisibleText("1992");
		
		logger.info("Checked if the RadioButton isEnabled or not.");
		System.out.println("Is Radio Button is Enabled ? Answer is ----> "+RadioButton.isEnabled());

		logger.info("Checked if the RadioButton isDisplayed or not.");
		System.out.println("Is Radio Button is Enabled ? Answer is ----> "+RadioButton.isDisplayed());
		
		logger.info("Clicked on the RadioButon");
		RadioButton.click();
		
		System.out.println("Is Submit Button is Enabled? Answer is ----> "+submitButton.isEnabled());
		System.out.println("Is Submit Button is Enabled? Answer is ----> "+submitButton.isDisplayed());
		
		logger.info("Clicked on the Submitted Button");
		submitButton.click();
		
	}
	
	public void Google_CalenderVerify() throws InterruptedException
	{
		logger.info("Clicked on the Google Calender link");
		Google_Calender.click();
		Thread.sleep(2000);
		
		logger.info("Got the title of the current page");
		System.out.println("The current title of google Calender is : "+driver.getTitle());
		
		logger.info("Got the URL of the current page");
		System.out.println("The Current URL of the google calender page is "+ driver.getCurrentUrl());
		Thread.sleep(2000);
		
		logger.info("Navigated back to the page");
		driver.navigate().back();
		
	}
}
