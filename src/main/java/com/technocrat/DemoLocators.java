package com.technocrat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoLocators {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost/login.do");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("admin");
		driver.findElement(By.id("loginButton")).click();
		
		driver.findElement(By.linkText("Reports")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.partialLinkText("System")).click();
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.tagName("a"));
		
		System.out.println(element.getText());
		
		List<WebElement> elements =  driver.findElements(By.tagName("a"));
		System.out.println(elements.size());
		
		for(int i=0; i<elements.size();i++) {
			System.out.println(elements.get(i).getText());
		}
		
		driver.close();
	}
}
