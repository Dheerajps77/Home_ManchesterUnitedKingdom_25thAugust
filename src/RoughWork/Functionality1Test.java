package RoughWork;

import org.testng.Assert;
import org.testng.annotations.Test;
 
public class Functionality1Test extends Demo_BaseTest
{
    @Test
    public void functionality1Test1()
    {
        test = extent.createTest("functionality1Test1");
        Assert.assertTrue(1 > 0);
    }
     
    @Test
    public void functionality1Test2()
    {
        test = extent.createTest("functionality1Test2");
        Assert.assertEquals("Krishna", "Sakinala");
    }
     
    @Test
    public void functionality1Test3()
    {
        test = extent.createTest("functionality1Test3");
        Assert.assertNotEquals("Krishna", "Krishna");
    }
}