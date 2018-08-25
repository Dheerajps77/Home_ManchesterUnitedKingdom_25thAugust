package RoughWork;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class MercuryLoginPageClass extends TestBaseApp{
	
	MercuryLoginPage ObjectLoginPage;
	
	public static Logger logger=Logger.getLogger(MercuryLoginPageClass.class.getName());
	public String Log_path=System.getProperty("user.dir")+"/Log4jFolder/Log4j.properties";
	
	@BeforeTest
	public void SettingLog4j()
	{
		PropertyConfigurator.configure(Log_path);
		
	}
	
	@BeforeMethod
	public void StartedMethod(Method method)
	{
		e3=e2.createTest(this.getClass().getSimpleName() + " : : " + method.getName(), " has been started");
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			e3.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			e3.log(Status.FAIL, result.getThrowable());
			e3.log(Status.FAIL, result.getName()+" module has been failed");
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			e3.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
			e3.log(Status.PASS, result.getName()+" module has been passed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			e3.log(Status.SKIP, result.getThrowable());
			e3.log(Status.SKIP, "module has been skipped...");
			e3.log(Status.SKIP, result.getName()+" module has been skipped");
			
			throw new SkipException("This MOdule is not for testing purpose.. So skipping this one...");
		}
	}

	@Test(priority=0)
	public void LoginFlow()
	{
		logger.info("============STARTED SESSION-->Mercury Login Page=============================");
		logger.info("Called the Mercury Login Page");
		ObjectLoginPage=PageFactory.initElements(driver, MercuryLoginPage.class);
		ObjectLoginPage.LoginModule();
		
	}
	
	@Test(priority=1)
	public void RegistrationFlow()
	{
		//e3=e2.createTest("This module has been started");
		logger.info("Logging the information of Registration Flow");
		logger.info("Compared the Assert value ====> Passed");
		Assert.assertEquals("Dheeraj", "Dheeraj");
	}
	
	@Test(priority=2)
	public void ResetPasswordFlow()
	{
		//e3=e2.createTest("This module has been started");
		
		logger.info("Logging the information of Reset Password Flow");	
		logger.info("Compared the Assert value ====> Failed");
		Assert.assertEquals("Dheeraj", "Singh");
	}
	
	@Test(priority=3)
	public void SendMoneyFlow()
	{
		//e3=e2.createTest("This module has been started");
		
		logger.info("Logging the information of Send Money Flow");
		logger.info("Compared the Assert value ====> Failed");
		Assert.assertEquals("Dheeraj", "Singh");
	}
	
	@Test(priority=4)
	public void ContactUsFlow()
	{
		//e3=e2.createTest("This module has been started");
		
		logger.info("Logging the information of Contact Us Page Flow");
		logger.info("Compared the Assert value ====> Failed");
		logger.info("============END SESSION-->Mercury Login Page=============================");
		Assert.assertEquals("Dheeraj", "Singh");
		
		logger.info("============END SESSION-->Mercury Login Page=============================");
	}
	
	@Test(priority=4, enabled=true)
	public void SkippingMethodFlow()
	{
		//e3=e2.createTest("This module has been started");
		
		logger.info("Logging the information of Send Money Flow");
		logger.info("Compared the Assert value ====> Failed");
		Assert.assertEquals("Dheeraj", "Dheeraj");
	}
}
