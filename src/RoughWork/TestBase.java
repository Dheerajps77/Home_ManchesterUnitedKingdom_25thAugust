package RoughWork;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;

public class TestBase {
	private static final Logger logger = Logger.getLogger(TestBase.class.getName());
	
	@BeforeTest
	public void loadlog4J(){
		String path="D:\\Eclipse selenium Program\\ManchesterUnitedKingdom\\LogsFiles\\log4j.properties";
		PropertyConfigurator.configure(path);
	}

}