package com.asynctric.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asynctric.qa.base.TestBase;

public class HomePage extends TestBase{

	//Initilization page factory
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	//Page Factory --OR
	
	@FindBy(xpath="//img[contains(@class,jss28)]")
	WebElement HomepageLogo;
	
	@FindBy(xpath="//p[contains(text(),'Profile')]")
	WebElement profile;
	
	@FindBy(xpath="//span[contains(text(),'Account')]")
	WebElement account;
	
	public boolean Validatehomepageimage()
	{
		return HomepageLogo.isDisplayed();
	}
	public AddressPage MoveToAddressPage() throws IOException
	{
		profile.click();
		account.click();
		return new AddressPage();
		
	}
	
}