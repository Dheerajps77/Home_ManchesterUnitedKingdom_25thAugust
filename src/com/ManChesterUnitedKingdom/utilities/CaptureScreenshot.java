package com.ManChesterUnitedKingdom.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot 
{
	
	public static String ScreenshotCapturing(WebDriver driver, String ScreenshotName) throws Exception 
	{	
		String path="E:\\Users\\dheeraj.p\\workspace\\MarsVersionEclipse\\Home_MUK\\Home_ManchesterUnitedKingdom_25thJuly\\ScreenshotsFolder\\"+ScreenshotName+".png";
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File fs=screenshot.getScreenshotAs(OutputType.FILE);
		File path_destination=new File(path);
		FileUtils.copyFile(fs, path_destination);
		return path;
		
	}

}
