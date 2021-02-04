package com.asynctric.qa.pages;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.asynctric.qa.base.TestBase;
import com.asynctric.qa.util.CommonMethod;

public class HomePage extends TestBase{

	String child;
	CommonMethod cm =new CommonMethod();
	
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
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/footer[1]/div[2]/div[1]/div[4]/div[1]/a[1]/*[1]")
	WebElement facebook;
	
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
	public void scrolldown() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		facebook.click();
		child=cm.windowhandle();
		driver.switchTo().window(child);
		System.out.println(driver.getCurrentUrl());
	}
	
}