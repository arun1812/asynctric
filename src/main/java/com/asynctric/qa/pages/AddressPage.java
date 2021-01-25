package com.asynctric.qa.pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.asynctric.qa.base.TestBase;

public class AddressPage extends TestBase {

	public AddressPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Address")
	WebElement address;
	@FindBy(xpath="//p[contains(text(),'Add new address')]")
	WebElement AddnewAddress;
	@FindBy(name="name")
	WebElement name;
	@FindBy(name="line1")
	WebElement AddressLine1;
	@FindBy(name="line2")
	WebElement AddressLine2;
	@FindBy(name="landmark")
	WebElement landmark;
	@FindBy(name="city")
	WebElement city;
	@FindBy(id="state-select")
	WebElement state;
	private List<WebElement> statename;
	@FindBy(xpath="//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li")
	List<WebElement> list= statename;

	@FindBy(name="pincode")
	WebElement pincode;
	@FindBy(name="mobile")
	WebElement mobile;
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement save;
	@FindBy(xpath="//span[@id='snackbar-message-id']")
	WebElement coformationmessage;
	
	public void NewAddressForm() throws InterruptedException
	{
	
		address.click();
		Thread.sleep(5000);
		//WebDriverWait w=new WebDriverWait(driver, 50);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Add new address')]")));
		AddnewAddress.click();
		name.sendKeys(prop.getProperty("Name"));
		AddressLine1.sendKeys(prop.getProperty("Addressline1"));
		AddressLine2.sendKeys(prop.getProperty("AddressLine2"));
		landmark.sendKeys(prop.getProperty("LandMark"));
		city.sendKeys(prop.getProperty("City"));
		state.click();
		
	    for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals(prop.getProperty("State")))
			{
				list.get(i).click();
			break;
			}
		}
		pincode.sendKeys(prop.getProperty("Pincode"));
		mobile.sendKeys(prop.getProperty("Mobile"));
		save.click();
		Thread.sleep(5000);
		 System.out.println(coformationmessage.getText()); 
		
	}
	
}
 