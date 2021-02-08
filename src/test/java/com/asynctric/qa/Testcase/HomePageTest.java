package com.asynctric.qa.Testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.asynctric.qa.base.TestBase;
import com.asynctric.qa.pages.HomePage;
import com.asynctric.qa.pages.LoginPage;
import com.asynctric.qa.util.CommonMethod;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	CommonMethod cm =new CommonMethod();
	
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
	public void ValidatehomepageimageTest() throws IOException
	{
		boolean flag= homepage.Validatehomepageimage();
		AssertJUnit.assertTrue(flag);
		
		System.out.println("Home Page LoGO Available "+flag);
	}
	
	@Test(priority=2)
	
	public void MoveToAddressPageTest() throws IOException
	{
		homepage.MoveToAddressPage();
		System.out.println("Address Page Open");
	}
	@Test(groups={"smoke"})
	public void scrolldownTest() throws InterruptedException, IOException
	{
		homepage.scrolldown();
	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
}