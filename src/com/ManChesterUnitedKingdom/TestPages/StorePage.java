package com.ManChesterUnitedKingdom.TestPages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StorePage 
{
		
	
	WebDriver driver;
	public StorePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//li//a[@data-track-text='Store']//span[text()='Store' and @class='web']")
	WebElement Store_link;
	
	@FindBy(how=How.XPATH, using="//ul[contains(@class,'home-header__sub-data')]//li//a[@data-track-text='Kits']")
	WebElement Kits_link;
	
	@FindBy(how=How.XPATH, using="//li[@id='manchesterMens']")
	WebElement MenLink;
	
	public void StoreLink() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(Store_link).build().perform();
		Thread.sleep(2000);
		
		Kits_link.click();
	}
	
	public void Men() throws InterruptedException
	{
		Set<String> windows=driver.getWindowHandles();
		System.out.println(windows);
		
		Iterator<String> its=windows.iterator();
		String parentWindow=its.next();
		
		driver.switchTo().window(parentWindow);
		System.out.println("Parent window ID must be :  "+ parentWindow);
		
		System.out.println("Parent Current URL is : ==> "+ driver.getCurrentUrl());
		System.out.println("Parent Current Title is : ==> " + driver.getTitle());
		driver.close();
		
		String childWindow=its.next();
		driver.switchTo().window(childWindow);
		System.out.println("Child window ID must be :  "+ childWindow);
		
		System.out.println("Child Current URL is : ==> "+ driver.getCurrentUrl());
		System.out.println("Child Current Title is : ==> " + driver.getTitle());
		
		Actions action=new Actions(driver);
		action.moveToElement(MenLink).build().perform();
		
		Thread.sleep(3000);
	}
}
