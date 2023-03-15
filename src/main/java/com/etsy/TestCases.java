package com.etsy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestCases extends TestBase {
	@Test(description = "Verify when user click on 'Register' link,then Registratiion page should open", enabled = false)
	public void verifyOnClickOnRegisterRegistrationPageShouldLaunch() throws InterruptedException {

		driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),\"Register\")]")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//p[contains(text(),'Registration')]"));
		Assert.assertFalse(elements.isEmpty());
		boolean enable = driver.findElement(By.xpath("//input[@name=\"first_name\"]")).isEnabled();
		Assert.assertTrue(enable);
		boolean display = driver.findElement(By.xpath("//button[@name=\"submit_attempt\"]")).isDisplayed();
		Assert.assertTrue(display);
	}
	@Ignore
	@Test
	public void verifyTipsAreAvailableDuringRegistrationProcess() throws InterruptedException {
		ArrayList<String> expectedTips = new ArrayList<String>();
		expectedTips.add("Don't use a previous password\nDon't use your name or email in the password\nUse 8 characters (6 characters minimum)\nUse a mix of numbers and symbols");

		driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),\"Register\")]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("xyz");
		ArrayList<String> actualTips=new ArrayList<String>();
		List<WebElement> tips=driver.findElements(By.xpath("(//div[contains(text(),'use')])[3]"));
		
		for(WebElement tip:tips) {
			String text=tip.getText();
			actualTips.add(text);
			}
		
		Assert.assertEquals(actualTips, expectedTips);
	}
	@Test
	public void verifyRegistrationProcess() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),\"Register\")]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("geeta041@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys("geeta");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("0000000");
		driver.findElement(By.xpath("//button[@name=\"submit_attempt\"]")).click();
		Thread.sleep(6000);
		boolean msgDisplay=driver.findElement(By.cssSelector("h1.wt-show-lg")).isDisplayed();
		Assert.assertTrue(msgDisplay);
		boolean enable=driver.findElement(By.xpath("//button[@aria-describedby='ge-tooltip-label-notifications']")).isEnabled();
		Assert.assertTrue(enable);
		boolean enable2=driver.findElement(By.xpath("//button[@aria-describedby='ge-tooltip-label-you-menu']")).isEnabled();
		Assert.assertTrue(enable2);
	}
}
