package com.crossBrowserTesting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTestCase {
	WebDriver driver;

	@Parameters("browser-name")
	@BeforeMethod
	public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"F:\\Testing\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
			// driver.get("https://www.carwale.com");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","F:\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"F:\\Testing\\Drivers\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			// driver.get("https://www.carwale.com");
		} else {
			System.out.println("Invalid browser name : " + browserName);
		}
	}

	@Test
	public void verifyRatings() throws InterruptedException {
		driver.get("https://www.carwale.com");
		driver.findElement(By.xpath("//input[@placeholder='Type to select car name']"))
				.sendKeys("Lamborghini Huracan STO");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Type to select car name']/preceding-sibling::div")).click();
		Thread.sleep(4000);
		String reviews = driver.findElement(By.xpath("(//a[contains(text(),'Reviews')])[1]")).getText();
		System.out.println("hello");
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(reviews);
		int noOfReviews = 0;
		while (m.find())
			noOfReviews = Integer.parseInt(m.group());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Read All User Reviews']")).click();
		Thread.sleep(2000);
		int actualReviews = driver.findElements(By.xpath("//ul[@data-lang-id='userreview_list_container']/li")).size();

		Assert.assertEquals(actualReviews, noOfReviews);
	}

}
