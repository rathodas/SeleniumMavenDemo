package com.technocrat;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestNG {

	
	@Test (priority = 0)
	public void login() {
		System.out.println("Login");
	}
	
	@Test(priority = 1)
	public void archive() {
		System.out.println("Archive");
	}
	
	
	
}
