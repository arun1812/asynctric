package com.asynctric.qa.pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asynctric.qa.base.TestBase;
import com.asynctric.qa.util.ExcelReader;

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
	//	Thread.sleep(5000);
		//WebDriverWait w=new WebDriverWait(driver, 50);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Add new address')]")));
		
	// Using Config file 
		
	/*	AddnewAddress.click();
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
		
		 */
// Using Excel Sheet	 
	
		ExcelReader Reader= new ExcelReader("D:\\Projects\\Asyncentric\\src\\main\\java\\com\\asynctric\\qa\\testdata\\AddressTestData.xlsx");
	int RowCount=Reader.getRowCount("Address");
	System.out.println(RowCount);
	for(int RowNum=2; RowNum<=RowCount;RowNum++ )
	{
		Thread.sleep(5000);
	String Name=Reader.getCellData("Address", "Name", RowNum);
	String Address=Reader.getCellData("Address", "Add Line 1", RowNum);
	String Address2=Reader.getCellData("Address", "Add Line 2", RowNum);
	String LandMark=Reader.getCellData("Address", "Land Mark", RowNum);
	String City=Reader.getCellData("Address", "City", RowNum);
	String State1=Reader.getCellData("Address", "State", RowNum);
	String Pincode=Reader.getCellData("Address", "Pincode", RowNum);
	String Mobile=Reader.getCellData("Address", "Mobile", RowNum);
		
			AddnewAddress.click();
		 
			name.sendKeys(Name);
			AddressLine1.sendKeys(Address);
			AddressLine2.sendKeys(Address2);
			landmark.sendKeys(LandMark);
			city.sendKeys(City);
			Thread.sleep(2000);
			state.click();
			
		    for(int i=0; i<list.size(); i++)
			{
				System.out.println(list.get(i).getText());
				if(list.get(i).getText().equals(State1))
				{
					list.get(i).click();
				break;
				}
			}
			pincode.sendKeys(Pincode);
			mobile.sendKeys(Mobile);
			save.click();
			Thread.sleep(5000);
			 System.out.println(coformationmessage.getText()); 
			 
	}
	
	}
	
}
 