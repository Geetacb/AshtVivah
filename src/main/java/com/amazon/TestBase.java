package com.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.gecko.driver","F:\\Testing\\Drivers\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		//WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		// driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void m1() {
		System.out.println("hello");
	}
}
