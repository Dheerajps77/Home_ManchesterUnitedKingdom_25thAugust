package ExtentReportDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class VerifyTitle {

	ExtentHtmlReporter htmlreporter;
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;

	@Test
	public void verifyBlogTitle() {
		
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/LearnAutomation.html");
		report=new ExtentReports();
		report.attachReporter(htmlreporter);
		
		logger = report.createTest("VerifyBlogTitle");

		logger.log(Status.INFO, "Browser started ");

		System.setProperty("webdriver.chrome.driver", "E:\\Selnium\\BrowserPath\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.learn-automation.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		

		logger.log(Status.INFO, "Application is up and running");

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Google"));

		logger.log(Status.PASS, "Title verified");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(Status.FAIL, "Title verification");

		}

		report.removeTest(logger);
		report.flush();
	}

}