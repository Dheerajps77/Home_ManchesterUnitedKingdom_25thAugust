package com.ManChesterUnitedKingdom.TestPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.asserts.SoftAssert;

public class Tickets_HospitalityPage 
{

	WebDriver driver;
	
	public Tickets_HospitalityPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	Actions action;
	
	@FindBy(how=How.XPATH, using="//span[text()='Tickets & Hospitality']")
	WebElement Tickets_Hospitality_link;
	
	@FindBy(how=How.XPATH, using="//li[contains(@class,' no-child  nav-item')]//a[text()='Home Match Tickets']")
	WebElement Match_tickets_link;
	
	@FindBy(how=How.XPATH, using="//a[@data-linkname='2018/19 Fixture list']//span")
	WebElement FixtureList_link;
	
	@FindBy(how=How.XPATH, using="//div[@class='home-header__menu-list sub-nav open']//ul[contains(@class,'home-header__sub-data  sub-nav-group')]//li")
	public List<WebElement>All_List;
	
	@FindBy(how=How.XPATH, using="//a[@data-track-text='Tour 2018 Tickets']")
	WebElement Tour_Tickets;
	
	@FindBy(how=How.XPATH, using="//a//span[text()='Real Madrid Tickets ']")
	WebElement RealMadrid_Link;
	
	@FindBy(how=How.XPATH, using="//div[text()='How many tickets?']//following::div[1]//div[contains(@class,'qty-picker')]//button[2]")
	WebElement IncrementalButton;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'split-content-primary landing-modal-body__section')]//following::div[1]//div[@class='price-slider']//div[@data-reactid='.1.1.1.0.1.3.1.0.0']//div[@class='rc-slider__label']//button")
	WebElement Starting_fee_price;
	
	@FindBy(how=How.XPATH, using="//button[text()='See tickets']")
	WebElement See_tickets_link;
	
	public void click_Tickets_Hospitality_link() throws InterruptedException
	{
		
		action=new Actions(driver);
		action.moveToElement(Tickets_Hospitality_link).build().perform();
		Thread.sleep(2000);
		int get_size=All_List.size();
		System.out.println("Total Nnumber of links are present : "+get_size);
		System.out.println("Below are the lists which is present under Tickets & Hospitality");
		
		for(int i=0;i<get_size;i++)
		{
			String total_List_text=All_List.get(i).getText();
			System.out.println("The text values of each list : "+total_List_text);
			
			String total_List_getTagName=All_List.get(i).getTagName();
			System.out.println("The TagName of this attribute is : "+total_List_getTagName);
		}
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		Match_tickets_link.click();
		
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);		
		}
	
	public void Tour_Tickets_2018() throws InterruptedException
	{
		action=new Actions(driver);
		action.moveToElement(Tickets_Hospitality_link).build().perform();
		Thread.sleep(2000);
		Tour_Tickets.click();
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1050)");
		Thread.sleep(2000);
	}
	
	public void Club_America() throws InterruptedException
	{
		
		RealMadrid_Link.click();
		Thread.sleep(2000);
		
		System.out.println("                                     ");
		System.out.println("========================Below are the URL of Tickets page====================");
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("                                     ");
		System.out.println("========================Below are the title of Tickets page====================");
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		IncrementalButton.click();
		IncrementalButton.click();
		IncrementalButton.click();
		IncrementalButton.click();
		
		//Starting_fee_price.click();
		Thread.sleep(2000);
		//Starting_fee_price.sendKeys(number);
		
		String titleOf=driver.findElement(By.xpath("//div[contains(@class,'landing-modal-header__event-name')]")).getText();
		
		System.out.println(titleOf);
		
		SoftAssert s1=new SoftAssert();
		s1.assertEquals(titleOf, "International Champions Cup: Manchester United v Real Madrid");
		System.out.println("Last statment got executed...");
		s1.assertAll();
		System.out.println("Title is OK. NO issue with title");
		See_tickets_link.click();
		Thread.sleep(3000);
	}
	
}