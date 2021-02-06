package com.asynctric.qa.Testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import com.asynctric.qa.base.TestBase;
import com.asynctric.qa.pages.HomePage;
import com.asynctric.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

		LoginPage loginpage;
		HomePage homepage;
		
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException 
	{
		Initialization();
		loginpage= new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginpage.ValidateLoginPageTitle();
		AssertJUnit.assertEquals(title, "ECart");
		System.out.println("Title is " +title );
	}
	@Test(priority=2)
	public void VlidateImageTest()
	{
		boolean flag= loginpage.ValidateImage();
		AssertJUnit.assertTrue(flag);
		System.out.println("Image Available "+flag);
	}
	@Test(groups={"smoke"})
	public void LoginTest() throws IOException 
	{
	homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	System.out.println("Home page URL is " + driver.getCurrentUrl());
	}
	@AfterMethod
	public void TearDowm() 
	{
		
		driver.quit();
	}
}
