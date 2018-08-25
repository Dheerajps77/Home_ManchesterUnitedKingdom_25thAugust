package com.ManChesterUnitedKingdom.TestPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class United_vs_TottenhamInHomePage 
{
	
	WebDriver driver;
	
	public static Logger logger=Logger.getLogger(United_vs_TottenhamInHomePage.class);
	public United_vs_TottenhamInHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='google_image_div']//a[@id='aw0']//img[@class='img_ad' and @src='https://tpc.googlesyndication.com/simgad/14284159804984662282']")
	@CacheLookup
	WebElement RegisterYourInterest;
	
	/*@FindBy(how=How.XPATH, using="//div[@class='mu-item article-card' and @data-share-title='United v Tottenham: Seven Old Trafford classics']//a//div//figure//img")
	@CacheLookup
	WebElement Link_United_vs_Tottenham;*/
	
	@FindBy(how=How.XPATH, using="//div[@class='mu-item__info']//a[@href='/en/news/detail/man-utd-v-tottenham-seven-classic-encounters']//h2")
	@CacheLookup
	WebElement Link_United_vs_Tottenham;
	
	public void ClickOnUnited_vs_TottenhamImage() throws InterruptedException
	{/*
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
*/		Thread.sleep(2000);

		Actions action=new Actions(driver);
		action.moveToElement(Link_United_vs_Tottenham).build().perform();
		Link_United_vs_Tottenham.click();
	}
	
	public void TitleAndUrlOfCurrentPage(){
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	

}
