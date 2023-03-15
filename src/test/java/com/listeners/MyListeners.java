package com.listeners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.etsy.TestBase;


import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class MyListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		AShot ashot=new AShot();
		Screenshot sc=ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(TestBase.driver);
		BufferedImage img=sc.getImage();
		String baseDir=System.getProperty("user.dir");
		try {
			ImageIO.write(img, "jpg", new File(baseDir+"/screenshots/LocalDateTime.now().jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
