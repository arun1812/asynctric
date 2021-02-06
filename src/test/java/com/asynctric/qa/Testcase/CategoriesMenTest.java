package com.asynctric.qa.Testcase;

import org.testng.annotations.Test;
import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import com.asynctric.qa.base.TestBase;
import com.asynctric.qa.pages.CategoriesMen;
import com.asynctric.qa.pages.HomePage;
import com.asynctric.qa.pages.LoginPage;

public class CategoriesMenTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	CategoriesMen categorypage;
	public CategoriesMenTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setpage() throws IOException 
	{
		Initialization();
		loginpage=new LoginPage();
		categorypage=new CategoriesMen();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(groups={"smoke"})
	public void AddProductFirstTest() throws InterruptedException
	{
		categorypage.AddProductFirst();
	}
	
	@Test(priority=2)
	public void AddProductSecondTest() throws InterruptedException
	{
		categorypage.AddProductSecond();
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
		
	}
}
