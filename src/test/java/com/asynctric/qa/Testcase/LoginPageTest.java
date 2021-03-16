package com.asynctric.qa.Testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import com.asynctric.qa.base.TestBase;
import com.asynctric.qa.pages.HomePage;
import com.asynctric.qa.pages.LoginPage;
import com.asynctric.qa.util.CommonMethod;

public class LoginPageTest extends TestBase{
public static Logger log=LogManager.getLogger(TestBase.class.getName());
CommonMethod cm =new CommonMethod();
		LoginPage loginpage;
		HomePage homepage;
		String username,password;
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void setup() throws IOException 
	{
		Initialization();
		loginpage= new LoginPage();
	log.info("All setup successfuly");
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginpage.ValidateLoginPageTitle();
		AssertJUnit.assertEquals(title, "ECart");
		System.out.println("Title is " +title );
	log.info("Title is " +title);
	}
	@Test(priority=2)
	public void VlidateImageTest()
	{
		boolean flag= loginpage.ValidateImage();
		AssertJUnit.assertTrue(flag);
		System.out.println("Image Available "+flag);
	log.info("Image Available "+flag);
	}
	@Test(groups="smoke")
	public void LoginTest() throws IOException, SQLException 
	{
	//homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	username=cm.DatabaseConnection(username, password);
	homepage=loginpage.Login(username,"arun");
	System.out.println("Home page URL is " + driver.getCurrentUrl());
	log.info("Login Succesfull and  Home page URL is " + driver.getCurrentUrl());
	}
	@AfterMethod
	public void TearDowm() 
	{
		
		driver.quit();
	}
}
