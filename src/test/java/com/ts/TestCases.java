package com.ts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.etsy.TestBase;
import com.listeners.MyListeners;
@Listeners(MyListeners.class)
public class TestCases extends TestBase{
	//public static WebDriver driver;

	@Test
	public void verifyName() {
		String expMsg = "SignIn";
		//System.setProperty("webdriver.chrome.driver", "F:\\JARs\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		String btn = driver.findElement(By.xpath("//a[contains(text(),'Log')]")).getText();
		Assert.assertEquals(expMsg, btn);
		driver.quit();
	}
}
