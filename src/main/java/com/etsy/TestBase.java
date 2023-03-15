package com.etsy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBase {
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","F:\\Testing\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.etsy.com");
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
}
