package RoughWork;

import com.ManChesterUnitedKingdom.utilities.CaptureScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBaseApp {

	WebDriver driver;

	public ExtentHtmlReporter e1;
	public ExtentReports e2;
	public ExtentTest e3;

	@BeforeSuite
	public void ExtentReportSetUp() {
		e1 = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/NewExtentReport.html");
		e2 = new ExtentReports();
		e2.attachReporter(e1);
		
		e2.setSystemInfo("OS", "Window 10");
		e2.setSystemInfo("Host Name", "Dheeraj");
		e2.setSystemInfo("Environment", "QA");
		e2.setSystemInfo("User Name", "Dheeraj Pratap Singh");
       
		e1.config().setChartVisibilityOnOpen(true);
		e1.config().setDocumentTitle("Automation testing for extent reportes");
		e1.config().setReportName("Test case report for Login Module in Mercury site");
		e1.config().setTestViewChartLocation(ChartLocation.TOP);
		e1.config().setTheme(Theme.DARK);
	}

	
	/*@BeforeMethod
	public void StartedMethod(Method method)
	{
		extenttest=extentreports.createTest(this.getClass().getSimpleName() + " :: " + method.getName(), method.getName());
		//extenttest=extentreports.createTest(method.getName() + " module has been started...");
	}
	@AfterMethod
	public void getResult(ITestResult result) throws Exception 
	{
		if(result.getStatus() == ITestResult.FAILURE)
        {
			
			extenttest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
			extenttest.fail(result.getThrowable());
			CaptureScreenshot.ScreenshotCapturing(driver, result.getName()+" name");
			
			extenttest.log(Status.FAIL, "Test case for this module has been failed");
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
        	extenttest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        	extenttest.log(Status.PASS, "Test case for this module has been Passed");
        }
        else if(result.getStatus()==ITestResult.SKIP)
        {
        	extenttest.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
        	extenttest.skip(result.getThrowable());
        	extenttest.log(Status.SKIP, "Test case for this module has been Skipped");
        }

	}*/
	@AfterSuite
	public void teardown() 
	{
		e2.flush();

	}
	
	@BeforeTest
	public void OpeningBroswer() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selnium\\BrowserPath\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(3000);
		
		
		String Current_URL=driver.getCurrentUrl();
		String Current_Title=driver.getTitle();
		
		System.out.println(Current_URL);
		System.out.println(Current_Title);
	}
	
	@AfterClass
	public void CLoseBroswer()
	{
		driver.close();
	}
	
}
