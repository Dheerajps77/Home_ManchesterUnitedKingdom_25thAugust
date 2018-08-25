package RoughWork;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Log4jExample extends TestBase
{
	private static final Logger logger=Logger.getLogger(Log4jExample.class.getName());
	
	ExtentHtmlReporter report=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/MyOwnReport.html");
	ExtentReports extend=new ExtentReports();
	@Test
	public void first()
	{
		extend.attachReporter(report);
		ExtentTest test=extend.createTest("First Method");
		test.log(Status.INFO, "This the test case of First Method");
		
		logger.info("================This is first message===========");
	}
	
	@Test
	public void second()
	{
		extend.attachReporter(report);
		ExtentTest test1=extend.createTest("Second Method");
		test1.log(Status.INFO, "This the test case of Second Method");
		
		logger.info("================This is Second message===========");		
	}
	
	@Test
	public void Third(){
		extend.attachReporter(report);
		ExtentTest test2=extend.createTest("Third Method");
		test2.log(Status.INFO, "This the test case of Third Method");
		logger.info("================This is Third message===========");

	}
	
	@Test
	public void Fourth(){
		
		extend.attachReporter(report);
		ExtentTest test3=extend.createTest("Fourth Method");
		test3.log(Status.INFO, "This the test case of Fourth Method");
		logger.info("================This is fourth message===========");

	}
	
	@Test(enabled=false)
	public void login(){
		extend.attachReporter(report);
		ExtentTest test4=extend.createTest("Login method");
		test4.log(Status.INFO, "This the test case of Login Method");
		
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
        
        driver.get("http://healthunify.com/bmicalculator/");
        logger.info("opening webiste");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        logger.info("entring weight");
		 driver.findElement(By.name("wg")).sendKeys("87");
		 logger.info("selecting kilograms");
        driver.findElement(By.name("opt1")).sendKeys("kilograms");
        logger.info("selecting height in feet");
        driver.findElement(By.name("opt2")).sendKeys("5");
        logger.info("selecting height in inchs");
        driver.findElement(By.name("opt3")).sendKeys("10");
        logger.info("Clicking on calculate");
        driver.findElement(By.name("cc")).click();

        logger.info("Getting SIUnit value");
        String SIUnit = driver.findElement(By.name("si")).getAttribute("value");
        logger.info("Getting USUnit value");
        String USUnit = driver.findElement(By.name("us")).getAttribute("value");
        logger.info("Getting UKUnit value");
        String UKUnit = driver.findElement(By.name("uk")).getAttribute("value");
        logger.info("Getting overall description");
        String note = driver.findElement(By.name("desc")).getAttribute("value");
     
        System.out.println("SIUnit = " + SIUnit);
        System.out.println("USUnit = " + USUnit);
        System.out.println("UKUnit = " + UKUnit);
        System.out.println("note = " + note); 
		driver.quit();
	}
}