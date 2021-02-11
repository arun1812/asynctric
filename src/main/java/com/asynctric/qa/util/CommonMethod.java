package com.asynctric.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.asynctric.qa.base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CommonMethod extends TestBase{

	static ExtentReports extent;
	public CommonMethod() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String windowhandle()
	{
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String	Parentwindow=it.next();
		String	ChildWindow=it.next();
		return ChildWindow;
	}
	public void Screenshot(String Location, String Filename) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(Location + Filename+ ".png"));
	}
	
	public static ExtentReports ExtentReport()
	{
		 String reportpath= System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(reportpath);
		reporter.config().setDocumentTitle("Ecart Test Result");
		reporter.config().setReportName("Ecart Web Application Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Arun Dubey");
		return extent;
		
	}
}
