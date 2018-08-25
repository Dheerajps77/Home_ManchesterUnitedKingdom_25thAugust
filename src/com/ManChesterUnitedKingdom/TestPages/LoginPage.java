package com.ManChesterUnitedKingdom.TestPages;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


public class LoginPage 
{
	public static Logger logger=Logger.getLogger(LoginPage.class);
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//li[@id='gigyalogin']//a[@data-track-text='Log In']")
	WebElement Login_Link;

	@FindBy(how = How.XPATH, using = "//input[@name='username' and @placeholder='Email address *']")
	WebElement EmailAddress;

	@FindBy(how = How.XPATH, using = "//input[@type='password' and @placeholder='Password *']")
	WebElement Pass;

	@FindBy(how = How.XPATH, using = "//input[@value='LOG IN']")
	WebElement Login_button;

	@FindBy(how=How.XPATH, using="//span[text()='My United' and @class='web']")
	WebElement hover_MyUnited;
	
	@FindBy(how=How.XPATH, using="//a[@data-track-text='Settings']")
	WebElement _Setting;
	
	@FindBy(how=How.XPATH, using="//span[text()='My Profile']")
	WebElement _MyProfile;
	
	@FindBy(how=How.XPATH, using="//a[@class='profile-text accord-title']//span[text()='logout']")
	WebElement _logout;
	
	
	@FindBy(how=How.XPATH, using="//span[text()='Change Password']")
	WebElement _ChangePassword;
	
	@FindBy(how=How.XPATH, using="//input[@data-gigya-placeholder='Current Password']")
	WebElement _CurrentPassword;
	
	@FindBy(how=How.XPATH, using="//input[@data-gigya-placeholder='New Password']")
	WebElement _NewPassword;
	
	@FindBy(how=How.XPATH, using="//input[@data-gigya-placeholder='Retype new password']")
	WebElement _RetypePassword;
	
	@FindBy(how=How.XPATH, using="//input[@value='Submit' and @class='gigya-input-submit']")
	WebElement _SubmittPassword;
	
	@FindBy(how=How.XPATH, using="//h2[text()='Your password has been changed successfully.']")
	WebElement _Message;
	
	@FindBy(how=How.XPATH, using="//input[@type='button' and @value='Continue']")
	WebElement _ContinueButton;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'gigya-screen-dialog-caption')]")
	WebElement _TitleOfChangePassword;
	
	
	@FindBy(how=How.XPATH, using="//a[text()='Forgot password?']")
	WebElement _ForgotPassword;
	
	@FindBy(how=How.XPATH, using="//input[@placeholder='Email address *']")
	WebElement _Enter_emailID;
	
	@FindBy(how=How.XPATH, using="//input[@type='submit' and @value='Submit']")
	WebElement _Submit;
	
	@FindBy(how=How.XPATH, using="//input[@type='text']")
	WebElement YopM_EnterYOurEMailID;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'um')]//a[@href='m.php?b=testloginmanchester&id=me_ZGtjAmVjZGR0BQD5ZQNjZmxjZmH3Zj==']")
	WebElement YopM_PasswordReset_Link;
	
	@FindBy(how=How.XPATH, using="//font[text()='RESET PASSWORD']")
	WebElement Yop_submit;
	
	@FindBy(how=How.XPATH, using="//input[@title='Check inbox @yopmail.com']")
	WebElement Check_inboxButton;
	
	@FindBy(how=How.XPATH, using="//a[@rel='nofollow']//font")
	WebElement Reset_Button;
	
	@FindBy(how=How.XPATH, using="//label[@for='gigya-password-newPassword']//span[text()='Please enter a new password:']//following::input[1]")
	WebElement _newPassword;
	
	@FindBy(how=How.XPATH, using="//label[@for='gigya-password-passwordRetype']//span[text()='Confirm your new password:']//following::input[1]")
	WebElement _passwordRetype;
	
	@FindBy(how=How.XPATH, using="//input[@type='button' and @value='Reset']")
	WebElement _ResetButton;
	
	@FindBy(how=How.XPATH, using="//h2[text()='Your password has been reset successfully.']")
	WebElement getResetPasswordText;
	
	
	@FindBy(how=How.XPATH, using="//input[@value='Continue']")
	WebElement _ContinueButtonAfterResetPassword;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void LoginPag(String UserID, String Password) throws InterruptedException {
		
		logger.info("Clicked on Login link");
		Login_Link.click();
		
		logger.info("Entered email ID in the textField");
		EmailAddress.sendKeys(UserID);
		
		logger.info("Entered Password in the textField");
		Pass.sendKeys(Password);
		
		logger.info("Clicked on Login button");
		Login_button.click();
		Thread.sleep(3000);
	}
	
	public void ChangePassword() throws InterruptedException
	{
		
		logger.info("Clicked on Change Password button");
		_ChangePassword.click();
		
		logger.info("Entered Current Password in the textField");
		_CurrentPassword.sendKeys("Dheeraj@8");
		
		logger.info("Entered New Password in the textField");
		_NewPassword.sendKeys("Dheeraj@9");
		
		logger.info("Retyped Password in the textField");
		_RetypePassword.sendKeys("Dheeraj@");
		Thread.sleep(2000);
		
		logger.info("Submitted the password after clicking on the button");
		_SubmittPassword.click();
		
		logger.info("Clicked on Continue button");
		_ContinueButton.click();
		
	}
	public void LoginOut()throws InterruptedException
	{
		logger.info("Mouse has been hovered to the MyUnited Link");
		Actions action=new Actions(driver);
		action.moveToElement(hover_MyUnited).build().perform();
		
		logger.info("Clicked on Setting Button Link");
		Thread.sleep(2000);
		_Setting.click();
		
		logger.info("Clicked on Profile link");
		_MyProfile.click();
		Thread.sleep(2000);
		
		logger.info("Called the ChangePassword method");
		ChangePassword();
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		
		logger.info("Clicked on logout button");
		_logout.click();
		
		logger.info("Printed the messages");
		System.out.println("Test case passed...");
		Thread.sleep(2000);
	}
	

	
	public void ForgetPassword(String emailID, String emailID2, String firstPassword, String secondPassword)throws InterruptedException
	{
		logger.info("Clicked on the Login Link in the login page");
		Login_Link.click();
		
		logger.info("Clicked on ForgotPassword in the login page");
		_ForgotPassword.click();
		
		logger.info("Entered email ID in the textField in the login page");
		_Enter_emailID.sendKeys(emailID);
		
		logger.info("Clicked on the submit button");
		_Submit.click();
		Thread.sleep(6000);
		
		logger.info("Navigated to the Yopmail site for further action.");
		driver.navigate().to("http://www.yopmail.com/en/");
		Thread.sleep(2000);
		
		logger.info("Clearing the textfield in the Yopmail site.");
		YopM_EnterYOurEMailID.clear();
		
		logger.info("Entered email ID in the textField in the Yopmail site.");
		YopM_EnterYOurEMailID.sendKeys(emailID2);
		
		Thread.sleep(2000);
		
		logger.info("Clicked on the Inbox button in yopmail site.");
		Check_inboxButton.click();
		
		Thread.sleep(3000);
		
		logger.info("Switched to the Iframe in yopmail site.");
		driver.switchTo().frame("ifmail");
		
		logger.info("Clicked on the Reset button in the Yopmail site.");
		Reset_Button.click();
		
		Thread.sleep(3000);
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		
		String parent=it.next();
		System.out.println("The parent window ID is : "+parent);
		
		logger.info("Switched to the parent window.");
		driver.switchTo().window(parent);
		
		logger.info("Printed the CurrentURL of the parent window.");
		System.out.println(driver.getCurrentUrl());
		
		logger.info("Printed the CurrentTitle of the parent window.");
		System.out.println(driver.getTitle());
		System.out.println("=======================================");
		
		Thread.sleep(3000);
		
		logger.info("Closing the parent window.");
		driver.switchTo().window(parent).close();
		
		String child=it.next();
		System.out.println("The child window ID is : "+child);
		
		logger.info("Switched to the child window.");
		driver.switchTo().window(child);
		
		logger.info("Printed the CurrentURL of the Child window.");
		System.out.println(driver.getCurrentUrl());
		
		logger.info("Printed the CurrentTitle of the Child window.");
		System.out.println(driver.getTitle());
		//driver.switchTo().window(child).close();
		Thread.sleep(3000);
		
		logger.info("Entered the New Password");
		_newPassword.sendKeys(firstPassword);
		
		logger.info("Retyped the new password again.");
		_passwordRetype.sendKeys(secondPassword);
		
		logger.info("Clicked on the reset button.");
		_ResetButton.click();
		Thread.sleep(3000);
		
		
		String get_ResetPasswordMessage=getResetPasswordText.getText();
		System.out.println("===================================");
		
		logger.info("Printed the resetPassword message.");
		System.out.println(get_ResetPasswordMessage);
		System.out.println("===================================");
		
		String Expected_Result="Your password has been reset successfully.";
		
		logger.info("Validated the messages using assert.");
		Assert.assertEquals(get_ResetPasswordMessage, Expected_Result, "The messages is showing correct.... Test case passed for this secenario");
		
		logger.info("Clicked on the Continue button after reset password.");
		_ContinueButtonAfterResetPassword.click();
		
		logger.info("Got the current URL of the page.");
		System.out.println(driver.getCurrentUrl());
		
		logger.info("Got the current title of the page.");
		System.out.println(driver.getTitle());
		
	}
}
