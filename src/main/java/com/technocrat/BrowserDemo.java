package com.technocrat;

import javax.print.attribute.standard.Chromaticity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDemo {

	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		BrowserDemo browserDemo = new BrowserDemo();
		browserDemo.launchBrowser(driver, "chrome");
		
	}
	
	public WebDriver launchBrowser(WebDriver driver, String browserType) throws Exception {

		if(browserType.equalsIgnoreCase("chrome")) {
			String projectPath = System.getProperty("user.dir"); 
			System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserType.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			
		}else if(browserType.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		return driver;
		
		/*
		 * driver.manage().window().maximize();
		 * 
		 * driver.get("http://google.com");
		 * 
		 * driver.navigate().to("https://github.com/");
		 * 
		 * driver.findElement(By.linkText("Sign in")).click(); Thread.sleep(5000);
		 * //driver.navigate().back();
		 * driver.findElement(By.name("login")).sendKeys("rathodanil.s@gmail.com");
		 * Thread.sleep(5000); //driver.navigate().forward(); Thread.sleep(5000);
		 * 
		 * driver.findElement(By.id("password")).sendKeys("abcd");
		 * driver.findElement(By.name("commit")).click();
		 * 
		 * String message =
		 * driver.findElement(By.xpath("//*[@id='js-flash-container']/div/div/div")).
		 * getText(); System.out.println(message);
		 * 
		 * driver.navigate().refresh(); Thread.sleep(5000); driver.close();
		 */
		
	}
	
	public void teardown(WebDriver driver) {
		if(driver!=null) {
			driver.quit();
		}
	}
}
