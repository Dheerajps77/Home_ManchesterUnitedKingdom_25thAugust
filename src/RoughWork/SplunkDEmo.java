package RoughWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SplunkDEmo {

	public WebDriver driver;

	@BeforeTest
	public void OpeningBroswer() {

		System.setProperty("webdriver.chrome.driver", "E:\\Selnium\\BrowserPath\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://wusplunkrs.wuintranet.net/en-US/account/login?return_to=%2Fen-US%2F");

	}

	@Test
	public void SplunkMOdule() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("14109204");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Western!@1234");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		driver.findElement(By.xpath("//div[@data-appid='search']")).click();
		driver.findElement(By.xpath("//div//textarea[@placeholder='enter search here...']"))
				.sendKeys("index=wudigitalr3 EntryExitLog C1536");
		Thread.sleep(2000);
		WebElement TimeZone=driver.findElement(By.xpath("//form[@class='search-form']//table//tbody//tr//td[3]//div//a"));
		
		Actions action=new Actions(driver);
		action.moveToElement(TimeZone).build().perform();
		TimeZone.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-view='views/shared/timerangepicker/dialog/Master']//div[contains(@id,'presets_view')]")).click();
		driver.findElement(By.xpath("//div[@class='accordion-body']//ul[2]//li[4]")).click();
		driver.findElement(By.xpath("//td[@class='search-button']")).click();
	}

}
