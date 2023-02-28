package com.technocrat;

import javax.print.attribute.standard.Chromaticity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDemo {

	public static void main(String[] args) {
		
		BrowserDemo browserDemo = new BrowserDemo();
		browserDemo.launchBrowser("edge");
		
	}
	
	public void launchBrowser(String browserType) {
				
		WebDriver driver = null;
		if(browserType.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}else if(browserType.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			
		}else if(browserType.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		}
		
		driver.get("http://google.com");
		driver.close();
		
	}
}
