package com.asynctric.qa.Testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.asynctric.qa.base.TestBase;
import com.asynctric.qa.pages.RegistrationPage;

public class RegistrationPageTest extends TestBase{
		
		RegistrationPage regpage;
	
	public RegistrationPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void Setup() throws IOException
	{
		Initialization();
		regpage= new RegistrationPage();
	}
	
	
	@Test(priority=1)
	public void ValidateRegPageURLTest()
	{
		String currentURL= regpage.ValidateRegPageURL();
		AssertJUnit.assertEquals(currentURL, "https://ecomm-fed59.web.app/register");
		System.out.println("Current URL is :" + currentURL);
	}
	@Test(priority=2)
	public void ValidateRegPageTextTest()
	{
		String text=regpage.ValidateRegPageText();
		AssertJUnit.assertEquals(text, "Signup with Asyncentric");
		System.out.println("Current Page text : " + text );
	}
	@Test(priority=3)
	public void RegFormExcelTest() throws InterruptedException
	{
		regpage.RegFormExcel();
		
	}
	/*
	@Test(priority=3)
	public void RegFormNameTest()
	{
		regpage.RegFormName();
	}
	@Test(priority=4)
	public void RegFormEmailTest()
	{
		regpage.RegFormEmail();
	}
	@Test(priority=5)
	public void RegFormMobileTest()
	{
		regpage.RegFormMobile();
	}
	@Test(priority=6)
	public void RegFormPasswordTest()
	{
		regpage.RegFormPassword();
	}  
	@Test(priority=7)
	public void RegFormTest()
	{
		
		String conformationmsg=regpage.RegForm();
		//regpage.RegForm();
	//	Assert.assertEquals(conformationmsg, "Email already exists!");
		if(conformationmsg.equals("Email already exists!")||conformationmsg.equals("Phone already exists!") )
			regpage.Login();
		
		
	}*/
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
}
