package com.crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CrossBrowsers {
	public static WebDriver driver;

	@Parameters("browser-name")
	@BeforeMethod
	public void launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Testing\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://www.carwale.com");
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","F:\\Testing\\Drivers\\geckodriver-v0.32.0-win32");
			driver=new FirefoxDriver();
			driver.get("https://www.carwale.com");
		}
//		else if(browserName.equalsIgnoreCase("Edge")) {
//			driver=new EdgeDriver();
	//	driver.get("https://www.carwale.com");
//		}
		else {
			System.out.println("Invalid browser name : "+browserName);
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
