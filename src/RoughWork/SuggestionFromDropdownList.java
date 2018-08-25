package RoughWork;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SuggestionFromDropdownList {
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
	public void ClickOnSuggestionList() throws InterruptedException 
	{
		WebElement text_Field=driver.findElement(By.xpath("//input[@aria-label='Search']"));
		text_Field.sendKeys("Selenium");
		Thread.sleep(3000);

		List<WebElement> ListOfAllValues=driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		int getListofAllValues=ListOfAllValues.size();
		System.out.println("=================================");
		System.out.println("Total number of values is present in the dropdown are  : "+getListofAllValues);
		System.out.println("Total number of values present in the dropdown are as follow.");
		for(int i=0;i<getListofAllValues;i++)
		{
			String str=ListOfAllValues.get(i).getText();
			//String str1=ListOfAllValues.get(i).getTagName();
			System.out.println(str);
			//System.out.println(str1);
			
			if(ListOfAllValues.get(i).getText().contains("selenium webdriver"))
			{
				ListOfAllValues.get(i).click();
				break;
			}
		}
	}

	@AfterClass
	public void ClosingBroswer() {

	}

}
