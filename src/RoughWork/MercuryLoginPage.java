package RoughWork;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercuryLoginPage {

	WebDriver driver;

	public static Logger logger=Logger.getLogger(MercuryLoginPage.class.getName());
	public String path=System.getProperty("user.dir")+"/Log4jFolder/Log4j.properties";
	
	public MercuryLoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='userName']")
	WebElement username;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement password1;

	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	WebElement signin;

	public void LoginModule() {
		PropertyConfigurator.configure(path);
		
		logger.info("===============================Started LOGIN MODULE testing for this site===============================");
		logger.info("Entered the User name in the textField area");
		username.sendKeys("askmail29");
		
		logger.info("Entered the Password in the textField area");
		password1.sendKeys("askmail29");
		
		logger.info("Clicked on Login Button");
		signin.click();
		
		logger.info("===============================ENDED LOGIN MODULE testing for this site===============================");
	}

}
