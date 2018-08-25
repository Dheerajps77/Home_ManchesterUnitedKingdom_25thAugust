package RoughWork;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Contact 
{
	
	public static WebDriver driver;
	
	public static void main(String[] ar) throws InterruptedException{
		
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.manutd.com/");
//		driver.findElement(By.xpath("//a[text()='Help']")).click();
//		Thread.sleep(3000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,800)");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//h2[text()='Contact Us']//following::div[1]")).click();
//		
//		Thread.sleep(2000);
		driver.navigate().to("https://www.manutd.com/en/help/club-contacts");
		//driver.findElement(By.xpath("//p[text()='Match ticket and Season Ticket sales and enquiries']//following::div[1]//a[@data-track-type='link']")).click();
		//driver.navigate().refresh();
		
		List<WebElement> textOfAllPhoneNumber=driver.findElements(By.xpath("//div[contains(@class,'contact-us__no')]//a"));
		
		int total_size=textOfAllPhoneNumber.size();
		
		System.out.println("Total number of phone present in the Contact Us are as follow : "+total_size);
		System.out.println("===========================================================================");
		System.out.println("Below are the Phone Number which is present in Contact Us page");
		for(int i=0;i<total_size;i++)
		{
			String PrintAllNumber=textOfAllPhoneNumber.get(i).getText();
			System.out.println(PrintAllNumber);
			
//			WebElement element=textOfAllPhoneNumber.get(i);
//			String innerHTMLofvalue=element.getAttribute("innerHTML");
//			System.out.println("The Innher HTML is : "+innerHTMLofvalue);
//			
		}
		
		
		List<WebElement> TitleOf=driver.findElements(By.xpath("//div[contains(@class,'contact-us__phone--list')]//p"));
		int total_size_ofTitle=TitleOf.size();
		
		System.out.println("Total number of Title for each phonumber in the Contact Us are as follow : "+total_size_ofTitle);
		System.out.println("===========================================================================");
		System.out.println("Below are all titles of Phone Number which is present in Contact Us page");
		
		for(int i=0;i<total_size_ofTitle;i++)
		{
			String PrintTitle=TitleOf.get(i).getText();
			System.out.println(PrintTitle);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		//		String Parent=driver.getWindowHandle();
//		
//		System.out.println("The parent window title is : "+driver.getTitle());
//		
//		Set<String> Child=driver.getWindowHandles();
//		
//		int sizeofChildWindows=Child.size();
//		System.out.println("Total size of child window are : "+ sizeofChildWindows);
//		
//		for(String Child1 : Child)
//		{
//			
//			String ChildTitle=driver.switchTo().window(Child1).getTitle();
//			System.out.println("The Child window title is : "+ChildTitle);
//			driver.switchTo().window(Child1).close();
//			
			
		}
	}
