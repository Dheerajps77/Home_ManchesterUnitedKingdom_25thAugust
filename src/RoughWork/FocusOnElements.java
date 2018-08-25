package RoughWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FocusOnElements {
	WebDriver driver;

	@BeforeTest
	public void OpeningBroswer() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selnium\\BrowserPath\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");

	}
	
	@Test
	public void FocusOnElement()
	{
		
		WebElement Focus=driver.findElement(By.xpath("//input[@name='btnI']"));
		Actions action=new Actions(driver);
		//action.moveToElement(Focus).clickAndHold().build().perform();
		action.moveToElement(Focus).build().perform();
	}
}
