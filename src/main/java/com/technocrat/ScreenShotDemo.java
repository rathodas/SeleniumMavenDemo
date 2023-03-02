package com.technocrat;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotDemo {
	
	public static void main(String[] args) throws Exception {
	
		WebDriver driver = null;
		BrowserDemo browserDemo = new BrowserDemo();
		driver = browserDemo.launchBrowser(driver, "chrome");
		
		ActiTimeHomePage actiTimeHomePage = new ActiTimeHomePage();
		actiTimeHomePage.navigateToActiTimeUrl(driver);
		ScreenShotDemo screenShotDemo = new ScreenShotDemo();
		screenShotDemo.screenshotUtils(driver, "D:\\Reports\\img1.jpg");
		actiTimeHomePage.loginToActiTime(driver);
		screenShotDemo.screenshotUtils(driver, "D:\\Reports\\img2.jpg");
		browserDemo.teardown(driver);
	
		
	}
	
	public void screenshotUtils(WebDriver driver, String dest) throws Exception {
	
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		
		File  srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(dest);
		
		FileHandler.copy(srcFile, destFile);
		
	}
}
