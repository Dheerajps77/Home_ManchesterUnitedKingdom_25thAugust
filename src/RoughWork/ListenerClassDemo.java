package RoughWork;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;


//@Listeners(RoughWork.ListenerClass.class)
public class ListenerClassDemo 
{
	
	
	@Test(priority=0)
	public void LoginPage()
	{
		//System.out.println("This is LoginPage Module");
		Assert.assertEquals(true, true);
	}
	
	@Test(priority=1)
	public void ProfilePage()
	{
		//System.out.println("This is ProfilePage Module");
		Assert.assertEquals(true, true);
		throw new SkipException("This module is getting skipp as it is not ready for as of now..");
	}
	
	@Test(priority=2)
	public void RegisterPage()
	{
		//System.out.println("This is RegisterPage Module");
		Assert.assertEquals(true, false);
	}
}
