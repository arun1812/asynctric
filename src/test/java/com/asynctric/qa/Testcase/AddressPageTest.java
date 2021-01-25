package com.asynctric.qa.Testcase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.asynctric.qa.base.TestBase;
import com.asynctric.qa.pages.AddressPage;
import com.asynctric.qa.pages.HomePage;
import com.asynctric.qa.pages.LoginPage;

public class AddressPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	AddressPage address;
	public AddressPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setpage() throws IOException 
	{
		Initialization();
		loginpage=new LoginPage();
		address=new AddressPage();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.MoveToAddressPage();
	}
	@Test
	public void NewAddressFormTest() throws InterruptedException
	{
		address.NewAddressForm();
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}
