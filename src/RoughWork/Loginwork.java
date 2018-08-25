package RoughWork;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class Loginwork 
{
	WebDriver driver;
	
	Logger log=Logger.getLogger("Loginwork");
	String logPath="D:\\Eclipse selenium Program\\ManchesterUnitedKingdom\\src\\com\\MUK\\Resources\\log4j.properties";
	
	@BeforeClass
	@Parameters({"broswer"})
	public void invoke_browser(String broswer)
	{
		log.debug("System is getting start");
		if(broswer.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJars\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.get("https://www.manutd.com/");
		}
		else if(broswer.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.get("https://www.manutd.com/");
		}
		
		else if(broswer.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\SeleniumJars\\IEDriverServer_x64_3.11.1\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.get("https://www.manutd.com/");
		}
//		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
//		driver=new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void Login()
	{
		
			driver.findElement(By.xpath("//li[@id='gigyalogin']//a[@data-track-text='Log In']")).click();
		
	}
	
	@AfterClass
	public void close_broswer()
	{
		driver.close();
		
	}

}
