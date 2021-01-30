package com.asynctric.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asynctric.qa.base.TestBase;

public class RegistrationPage extends TestBase {

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

	public String RegFormName()
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
	public String RegFormPassword()
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
		return coformationmessage.getText();
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
		
	}
}
