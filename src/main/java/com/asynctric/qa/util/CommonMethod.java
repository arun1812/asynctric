package com.asynctric.qa.util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.asynctric.qa.base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mysql.cj.protocol.Resultset;


public class CommonMethod extends TestBase{

	static ExtentReports extent;
	static String host="localhost";
	static String port="3306";
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
	public void Screenshot(String Filename) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Location=System.getProperty("user.dir")+"\\reports\\screenshots\\";
		FileUtils.copyFile(src, new File(Location + Filename+ ".png"));
	}
	
	public String ScreenshotForFailureTest(String testCaseName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationfilepath=System.getProperty("user.dir")+"\\reports\\FailureTestScreenShot\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationfilepath));
		return destinationfilepath;
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
	
	public  String DatabaseConnection(String username,String password) throws SQLException
	{
	Connection con=	DriverManager.getConnection("jdbc:mysql://"+host+":"+port+ "/test", "root" , "root");
	Statement s= con.createStatement();
	ResultSet rs= s.executeQuery("select * from user");
	while(rs.next())
	{
	username =rs.getString("User_Name");
	password =rs.getString("Password");
	
	}
	return username;	
	
	}
}
