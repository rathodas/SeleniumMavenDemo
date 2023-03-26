package com.technocrat;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoSyncronization {

	public static void main(String[] args) throws Exception {
		String projectPath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(option);

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.manage().window().maximize();
		driver.navigate().to("http://localhost/login.do");

		driver.findElement(By.name("username")).sendKeys("admin");
		//Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys("admin");
		driver.findElement(By.id("loginButton")).click();
		//Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Reports"))));
		
		driver.findElement(By.linkText("Reports")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='ext-comp-1014']/span"))));
		driver.findElement(By.xpath("//*[@id='ext-comp-1014']/span")).click();
		Thread.sleep(3000);
		driver.close();
	}
}
