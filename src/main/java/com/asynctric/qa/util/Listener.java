package com.asynctric.qa.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends CommonMethod implements ITestListener {
	
	public Listener() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	ExtentReports extent= CommonMethod.ExtentReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest= new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		
		 test= extent.createTest(result.getMethod().getMethodName());
		 extenttest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest.get().log(Status.PASS, "Test paased");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		extenttest.get().fail(result.getThrowable());
		
		String methodname=result.getMethod().getMethodName();
		
		try {
			extenttest.get().addScreenCaptureFromPath(ScreenshotForFailureTest(methodname), methodname);
			ScreenshotForFailureTest(methodname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		extent.flush();
	}

}
