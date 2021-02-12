package com.asynctric.qa.pages;


import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.asynctric.qa.base.TestBase;
import com.asynctric.qa.util.CommonMethod;
import com.asynctric.qa.util.ExcelReader;
public class RegistrationPage extends TestBase {

	CommonMethod cm=new CommonMethod();
//	String location="D:\\Projects\\screenshots\\Reg\\";
	public String conformationmsg;
	public RegistrationPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
// Page Factory --- OR
@FindBy(linkText="Create Account")
WebElement Registration;
@FindBy(id="name")
WebElement Name;
@FindBy(id="email")
WebElement Email;
@FindBy(id="mobile")
WebElement Mobile;
@FindBy(id="password")
WebElement Password;
@FindBy(xpath="//span[@class='MuiButton-label']")
WebElement Submit;
@FindBy(xpath="//h1[contains(text(),'Signup with Asyncentric')]")
WebElement RegistrationPageText;
@FindBy(xpath="//span[@id='snackbar-message-id']")
WebElement coformationmessage;
@FindBy(linkText="Login!")
WebElement Login;

	public String ValidateRegPageURL()
	{
		Registration.click();
		return driver.getCurrentUrl();
	}
	
	public String ValidateRegPageText()
	{
		Registration.click();
		return RegistrationPageText.getText();
	}

	public void RegFormExcel() throws InterruptedException, IOException
	{
		
		ExcelReader reader= new ExcelReader("D:\\Projects\\Asyncentric\\src\\main\\java\\com\\asynctric\\qa\\testdata\\AddressTestData.xlsx");
		int rowcount=reader.getRowCount("Registration");
		System.out.println("Row Count for registration sheet is :" + rowcount);
		Registration.click();
		for(int rowNum=2;rowNum<=rowcount;rowNum++)
		{
			Thread.sleep(5000);
		String name=reader.getCellData("Registration", "Name", rowNum);
		String email=reader.getCellData("Registration", "Email", rowNum);
		String mobile=reader.getCellData("Registration", "Mobile", rowNum);
		String password=reader.getCellData("Registration", "Password", rowNum);
		
		//Name.clear();
		Name.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		Name.sendKeys(name);
		//Email.clear();
		Email.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		Email.sendKeys(email);
		//Mobile.clear();
		Mobile.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		Mobile.sendKeys(mobile);
		//Password.clear();
		Password.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		Password.sendKeys(password);
		Submit.click();
		
		System.out.println(coformationmessage.getText());
		conformationmsg=coformationmessage.getText();
		cm.Screenshot(conformationmsg);
		/*File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(location + conformationmsg + ".png"));*/
		if(conformationmsg.equals("Email already exists!")||conformationmsg.equals("Phone already exists!") )
		{
			Thread.sleep(3000);
			Login.click();
			System.out.println("After Registration URL is :"+ driver.getCurrentUrl());
		}
		}
		
		
	}
	/*public String RegFormName()
	{
		Registration.click();
	//	Name.clear();
	//	Name.sendKeys("Arun");
		Email.clear();
		Email.sendKeys("arun5603@gmail.com");
		Mobile.clear();
		Mobile.sendKeys("9899001068");
		Password.clear();
		Password.sendKeys("12345");
		Submit.click();
		
		System.out.println(coformationmessage.getText());
		return coformationmessage.getText();
	}
	public String RegFormEmail()
	{
		Registration.click();
		Name.clear();
		Name.sendKeys("Arun");
	//	Email.clear();
	//	Email.sendKeys("arun5603@gmail.com");
		Mobile.clear();
		Mobile.sendKeys("9899001068");
		Password.clear();
		Password.sendKeys("12345");
		Submit.click();	
		System.out.println(coformationmessage.getText());
		return coformationmessage.getText();
	}
	public String RegFormMobile()
	{
		Registration.click();
		Name.clear();
		Name.sendKeys("Arun");
		Email.clear();
		Email.sendKeys("arun5603@gmail.com");
	//	Mobile.clear();
	//	Mobile.sendKeys("9899001068");
		Password.clear();
		Password.sendKeys("12345");
		Submit.click();	
		System.out.println(coformationmessage.getText());
		return coformationmessage.getText();
	}
	public void RegFormPassword()
	{
		Registration.click();
		Name.clear();
		Name.sendKeys("Arun");
		Email.clear();
		Email.sendKeys("arun5603@gmail.com");
		Mobile.clear();
		Mobile.sendKeys("9899001068");
	//	Password.clear();
	//	Password.sendKeys("12345");
		Submit.click();	
		System.out.println(coformationmessage.getText());
		//return coformationmessage.getText();
	}
	public String RegForm()
	{
		Registration.click();
		Name.clear();
		Name.sendKeys("Arun");
		Email.clear();
		Email.sendKeys("arun5603@gmail.com");
		Mobile.clear();
		Mobile.sendKeys("9899001068");
		Password.clear();
		Password.sendKeys("12345");
		Submit.click();	
		System.out.println(coformationmessage.getText());
		return coformationmessage.getText();
	}
	public void Login()
	{
		Login.click();
		System.out.println("After Registration URL is :"+ driver.getCurrentUrl());
		
	}*/
}
