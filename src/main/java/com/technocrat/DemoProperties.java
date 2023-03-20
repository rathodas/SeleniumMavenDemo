package com.technocrat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class DemoProperties {
 
	public static void main(String[] args) throws Exception  {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		FileInputStream file = new FileInputStream(path+"\\config.properties");	
		Properties prop = new Properties();

		prop.load(file);
		
		System.out.println("Name : "+ prop.getProperty("name"));
		System.out.println("Age : "+ prop.getProperty("age"));
		System.out.println("Gender : "+ prop.getProperty("Gender"));
		System.out.println("Gender : "+ prop.getProperty("gender"));
		
	}
}
