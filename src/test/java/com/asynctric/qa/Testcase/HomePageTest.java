package com.asynctric.qa.Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.asynctric.qa.base.TestBase;
import com.asynctric.qa.pages.HomePage;
import com.asynctric.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void setuphomepage() throws IOException 
	{
		Initialization();
		loginpage=new LoginPage();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void ValidatehomepageimageTest()
	{
		boolean flag= homepage.Validatehomepageimage();
		Assert.assertTrue(flag);
		System.out.println("Home Page LoGO Available "+flag);
	}
	
	@Test(priority=2)
	
	public void MoveToAddressPageTest() throws IOException
	{
		homepage.MoveToAddressPage();
		System.out.println("Address Page Open");
	}
	@Test(priority=3)
	public void scrolldownTest() throws InterruptedException
	{
		homepage.scrolldown();
	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
}
