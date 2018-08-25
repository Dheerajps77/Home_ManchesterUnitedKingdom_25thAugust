package com.ManChesterUnitedKingdom.TestPages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LanguageDropdownHomePage 
{
	WebDriver driver;
	
	public LanguageDropdownHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public static Logger logger=Logger.getLogger(LanguageDropdownHomePage.class);
	
	@FindBy(how=How.XPATH, using="//li[contains(@class,'home-dropdown')]//span//span")
	WebElement HoveringToLanguage;
	
	@FindBy(how=How.XPATH, using="//ul[@class='language-dropdown']//li")
	List<WebElement> CollectionLanguagetext;
	
	@FindBy(how=How.XPATH, using="//ul[@class='language-dropdown']//li[5]//a//span[text()='Español']")
	WebElement Click_Español;
	
	public void HovringToEnglishLanguage()
	{
		logger.info("Mouse hovered to the Dropdown");
		Actions Language_action=new Actions(driver);
		logger.info("Clicked is performed");
		Language_action.moveToElement(HoveringToLanguage).build().perform();
	}
	
	public void CollectingAllLanguagePresentText()
	{
		logger.info("Got the total number of Language present in the particular list");
		int get_SizeofLanguage=CollectionLanguagetext.size();
		System.out.println("===================================");
		
		logger.info("Printed all the langauge");
		System.out.println("Total number Language present in the list are : "+get_SizeofLanguage);
		System.out.println("===================================");
		
		logger.info("Used for-loop condition");
		logger.info("Got the text of all Language present in the list");
		System.out.println("Below are the Language text");
		for(int i=0;i<get_SizeofLanguage;i++)
		{
			String str=CollectionLanguagetext.get(i).getText();
			System.out.println(str);
		}
	}
	
	public void ClickOnESPAÑOL() throws InterruptedException
	{
		logger.info("Clicked on ESPAÑOL Language");
		Thread.sleep(2000);
		Click_Español.click();
		logger.info("Got the Current URL after clicked action perfomed on Espanol language");
		System.out.println(driver.getCurrentUrl());
		
		logger.info("Got the title of the current page after clicked action perfomed on Espanol language");
		System.out.println(driver.getTitle());
	}
}
