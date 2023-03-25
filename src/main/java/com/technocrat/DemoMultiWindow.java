package com.technocrat;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoMultiWindow {

	public static void main(String[] args) throws Exception {
		
		String projectPath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/browser-windows");
		
		driver.findElement(By.id("windowButton")).click();
		
		
		
		String parentWindow = driver.getWindowHandle();
		
		System.out.println(parentWindow);
		
		Set windows = driver.getWindowHandles();
		
		Object ids[] = windows.toArray();
		
		for(int i=0; i<ids.length; i++) {
			System.out.println(ids[i]);
		}
		
		driver.switchTo().window(ids[1].toString());
		
		String id = driver.getWindowHandle();
		
		System.out.println(id);
		
		driver.manage().window().maximize();
		
		String message = driver.findElement(By.id("sampleHeading")).getText();
		
		Thread.sleep(3000);
		System.out.println(message);
		
		driver.quit();
	}
}
