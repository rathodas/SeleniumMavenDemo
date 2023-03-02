package com.technocrat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActiTimeHomePage {

	public void navigateToActiTimeUrl(WebDriver driver) {
		driver.navigate().to("http://localhost/login.do");
	}
	
	public void loginToActiTime(WebDriver driver) {		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("admin");
		driver.findElement(By.id("loginButton")).click();
		
	}
}
