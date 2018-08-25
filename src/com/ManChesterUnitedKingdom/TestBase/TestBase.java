package com.ManChesterUnitedKingdom.TestBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase
{
	public static WebDriver driver;
	private static final Logger logger = Logger.getLogger(TestBase.class.getName());
	

	/*@BeforeClass
	public void SettingUpLo4j(){
		String path= System.getProperty("user.dir")+"/Log4jFolder/Log4j.properties";
		PropertyConfigurator.configure(path);
	}
	*/
	public ExtentHtmlReporter e1;
	public ExtentReports e2;
	public ExtentTest e3;
	
	public String ExtentPath=System.getProperty("user.dir")+"/ExtentReportFolder/"+this.getClass().getSimpleName()+".html";
	
	@BeforeSuite
	public void SettingUpExtentReports()
	{
		e1=new ExtentHtmlReporter(ExtentPath);
		e2=new ExtentReports();
		e2.attachReporter(e1);
		
		e2.setSystemInfo("Tester Name", "Dheeraj Pratap Singh");
		e2.setSystemInfo("UserName", "Dheeraj.Singh@westerunion.com");
		e2.setSystemInfo("Environment", "Production");
		e2.setSystemInfo("Sprint Name", "Flash");
		e2.setSystemInfo("Version Number", "ASHSJ1324_234");
		e2.setSystemInfo("Host", "127.0.0.1");
		
		e1.config().setDocumentTitle("This is automation testing module");
		e1.config().setTestViewChartLocation(ChartLocation.TOP);
		e1.config().setReportName("Automation testing for Manchester United Kingdom site.");
		e1.config().setTheme(Theme.DARK);
	}
	
	@
	AfterSuite
	public void GeneratingExtentReport(){
		e2.flush();
	}
	
	@BeforeTest
	@Parameters({"browser"})
	public void InvokeBroswer(String browser)
	{
		String path= System.getProperty("user.dir")+"/Log4jFolder/Log4j.properties";
		PropertyConfigurator.configure(path);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		
		logger.info("Browser path got set");
		System.setProperty("webdriver.chrome.driver", "E:\\Selnium\\BrowserPath\\chromedriver_win32\\chromedriver.exe");
		
		logger.info("Initiated the broswer driver");
		driver=new ChromeDriver();
		
		logger.info("Maximised the broswer");
		driver.manage().window().maximize();
		
		logger.info("Sync the broswer");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		
		logger.info("Broswer got opened");
		driver.get("https://www.manutd.com/");
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			logger.info("Browser path got set");
			System.setProperty("webdriver.ie.driver", "E:\\Selnium\\BrowserPath\\IEDriverServer_x64_3.13.0\\IEDriverServer.exe");
			
			logger.info("Initiated the broswer driver");
			driver=new InternetExplorerDriver();
			
			logger.info("Maximised the broswer");
			driver.manage().window().maximize();
			
			logger.info("Sync the broswer");
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			
			logger.info("Broswer got opened");
			driver.get("https://www.manutd.com/");			
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			logger.info("Browser path got set");
			System.setProperty("webdriver.gecko.driver", "E:\\Selnium\\BrowserPath\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			
			logger.info("Initiated the broswer driver");
			driver=new FirefoxDriver();
			
			logger.info("Maximised the broswer");
			driver.manage().window().maximize();
			
			logger.info("Sync the broswer");
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			
			logger.info("Broswer got opened");
			driver.get("https://www.manutd.com/");			
		}
		
		
	}
	
	@AfterClass
	public void CloseBroswer() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}

}
